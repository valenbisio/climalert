package ar.edu.utn.frba.dds.clima.services;

import ar.edu.utn.frba.dds.clima.entities.ClimaRegistro;
import ar.edu.utn.frba.dds.clima.repositories.ClimaRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AlertaService {
  private final ClimaRepository climaRepository;
  private ClimaRegistro ultimoRegistroAlertado;
  private final NotificacionesService notificacionesService;

  public AlertaService(
      ClimaRepository climaRepository,
      NotificacionesService notificacionesService) {
    this.climaRepository = climaRepository;
    this.notificacionesService = notificacionesService;
  }

  @Scheduled(fixedRate = 60000) //60000 1 minuto en milisegundos
  public void verificarAlerta() {
    ClimaRegistro ultimoClima = climaRepository.obtenerUltimo();
    if (ultimoClima == null) {
      return;
    }

    boolean esNuevoRegistro = ultimoRegistroAlertado == null
        || !ultimoRegistroAlertado.getFechaRegistrada().equals(ultimoClima.getFechaRegistrada());

    if (esNuevoRegistro && ultimoClima.getTemperatura() > 35 && ultimoClima.getHumedad() > 60) {
      this.ultimoRegistroAlertado = ultimoClima;
      notificacionesService.notificarAlerta(ultimoClima);
    }
  }
}
