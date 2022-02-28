package pe.edu.upc.cinewin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.cinewin.models.PeliculaModel;

public interface PeliculaRepository extends JpaRepository<PeliculaModel,Integer> {
}
