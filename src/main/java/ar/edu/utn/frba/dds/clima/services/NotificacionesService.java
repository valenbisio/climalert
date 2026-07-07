package ar.edu.utn.frba.dds.clima.services;

import ar.edu.utn.frba.dds.clima.config.AlertProperties;
import ar.edu.utn.frba.dds.clima.entities.ClimaRegistro;
import java.util.List;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacionesService {
  private final List<String> mails;
  private final JavaMailSender mailSender;

  public NotificacionesService(AlertProperties alertProperties, JavaMailSender mailSender) {
    this.mails = alertProperties.getMails();
    this.mailSender = mailSender;
  }

  public void notificarAlerta(ClimaRegistro clima) {
    for (String destinatario : mails) {
      SimpleMailMessage mensaje = new SimpleMailMessage();
      mensaje.setTo(destinatario);
      mensaje.setSubject("Alerta Climática!!!");
      mensaje.setText(mensajeDeAlerta(clima));
      mailSender.send(mensaje);
    }
  }

  private String mensajeDeAlerta(ClimaRegistro clima) {
    return String.format("ALERTA!!! TEMPERATURA: %.1f° HUMEDAD: %d%% CONDICION: %s",
        clima.getTemperatura(), clima.getHumedad(), clima.getCondicion());
  }
}
