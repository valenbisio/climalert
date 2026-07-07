package ar.edu.utn.frba.dds.clima.entities;

import ar.edu.utn.frba.dds.clima.dto.WeatherResponse;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClimaRegistro {
  private int id;
  private float temperatura;
  private int humedad;
  private String condicion;
  private LocalDateTime fechaRegistrada;

  public static ClimaRegistro toClimaRegistro(WeatherResponse dto) {
    ClimaRegistro registro = new ClimaRegistro();
    registro.setTemperatura(dto.getTemperatura());
    registro.setHumedad(dto.getHumedad());
    registro.setCondicion(dto.getCondicion());
    registro.setFechaRegistrada(LocalDateTime.now());
    return registro;
  }
}
