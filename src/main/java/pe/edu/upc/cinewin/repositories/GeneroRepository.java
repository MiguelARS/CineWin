package pe.edu.upc.cinewin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.cinewin.models.GeneroModel;

public interface GeneroRepository extends JpaRepository<GeneroModel,Integer> {
}
