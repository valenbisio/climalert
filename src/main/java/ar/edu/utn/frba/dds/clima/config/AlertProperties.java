package ar.edu.utn.frba.dds.clima.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alert")
@Component
public class AlertProperties {

  private List<String> mails;

  public List<String> getMails() {
    return List.copyOf(mails);
  }

  public void setMails(List<String> mails) {
    this.mails = new ArrayList<>(mails);
  }
}

