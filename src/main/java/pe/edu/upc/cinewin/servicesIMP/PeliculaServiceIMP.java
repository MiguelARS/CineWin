package pe.edu.upc.cinewin.servicesIMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.cinewin.dto.PeliculaDTO;
import pe.edu.upc.cinewin.models.PeliculaModel;
import pe.edu.upc.cinewin.repositories.PeliculaRepository;
import pe.edu.upc.cinewin.services.PeliculaService;

@Service
public class PeliculaServiceIMP implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public PeliculaDTO crearPelicula(PeliculaDTO peliculaDTO) {
        //Convertir de DTO a entidad
        PeliculaModel pelicula = new PeliculaModel();

        pelicula.setNombre(peliculaDTO.getNombre());
        pelicula.setDescripcion(peliculaDTO.getDescripcion());
        pelicula.setDuracion(peliculaDTO.getDuracion());
        pelicula.setFechaEstreno(peliculaDTO.getFechaEstreno());
        pelicula.setRating(peliculaDTO.getRating());
        pelicula.setLinkTrailer(peliculaDTO.getLinkTrailer());
        pelicula.setRutaPortada(peliculaDTO.getRutaPortada());

        PeliculaModel nuevaPelicula = peliculaRepository.save(pelicula);

        //Convertimos de entidad a DTO
        PeliculaDTO peliculaResponse = new PeliculaDTO();
        peliculaResponse.setId(nuevaPelicula.getId());
        peliculaResponse.setNombre(nuevaPelicula.getNombre());
        peliculaResponse.setDescripcion(nuevaPelicula.getDescripcion());
        peliculaResponse.setDuracion(nuevaPelicula.getDuracion());
        peliculaResponse.setFechaEstreno(nuevaPelicula.getFechaEstreno());
        peliculaResponse.setRating(nuevaPelicula.getRating());
        peliculaResponse.setLinkTrailer(nuevaPelicula.getLinkTrailer());
        peliculaResponse.setRutaPortada(nuevaPelicula.getRutaPortada());

        return peliculaResponse;
    }
}
