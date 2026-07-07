package ar.edu.utn.frba.dds.clima.services;

import ar.edu.utn.frba.dds.clima.dto.WeatherResponse;
import ar.edu.utn.frba.dds.clima.entities.ClimaRegistro;
import ar.edu.utn.frba.dds.clima.repositories.ClimaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

  private final ClimaRepository climaRepository;
  private final WebClient webClient = WebClient.create();

  @Value("${weatherapi.key}")
  private String apiKey;

  @Value("${weatherapi.base-url}")
  private String baseUrl;

  @Value("${weatherapi.location}")
  private String location;

  public WeatherService(ClimaRepository climaRepository) {
    this.climaRepository = climaRepository;
  }

  @Scheduled(fixedRate = 300000)
  public void fetchClima() {
    WeatherResponse dto = webClient.get()
        .uri(baseUrl + "/current.json?key={key}&q={location}", apiKey, location)
        .retrieve()
        .bodyToMono(WeatherResponse.class)
        .block();

    if (dto == null) {
      return;
    }

    ClimaRegistro clima = ClimaRegistro.toClimaRegistro(dto);
    climaRepository.save(clima);
  }
}
