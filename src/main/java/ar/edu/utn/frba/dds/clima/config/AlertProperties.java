package ar.edu.utn.frba.dds.clima.config;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alert")
@Component
@Getter
@Setter
public class AlertProperties {
  private List<String> mails;
}
