package ar.edu.utn.frba.dds.clima.repositories.InMemory;

import ar.edu.utn.frba.dds.clima.entities.ClimaRegistro;
import ar.edu.utn.frba.dds.clima.repositories.ClimaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryClimaRepository implements ClimaRepository {
  private final List<ClimaRegistro> climas = new ArrayList<>();;

  @Override
  public void save(ClimaRegistro clima){
      climas.add(clima);
  }
  @Override
  public ClimaRegistro obtenerUltimo(){
    if (climas.isEmpty()) {
      return null; // O lanzar una excepción personalizada si lo prefieres
    }
    return climas.getLast();
  }
}
