package ar.edu.utn.frba.dds.clima.dto;

import lombok.Getter;

@Getter
public class WeatherResponse {
  private float temperatura;
  private int humedad ;
  private String condicion;
}
