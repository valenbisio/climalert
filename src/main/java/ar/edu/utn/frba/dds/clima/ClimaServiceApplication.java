package ar.edu.utn.frba.dds.clima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClimaServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(ClimaServiceApplication.class, args);
  }
}
