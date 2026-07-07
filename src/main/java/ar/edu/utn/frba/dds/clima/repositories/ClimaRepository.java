package ar.edu.utn.frba.dds.clima.repositories;

import ar.edu.utn.frba.dds.clima.entities.ClimaRegistro;
import java.util.List;

public interface ClimaRepository {

  void save(ClimaRegistro clima);

  ClimaRegistro obtenerUltimo();
}
