package pe.edu.upc.cinewin.servicesIMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.cinewin.dto.PeliculaDTO;
import pe.edu.upc.cinewin.exceptions.ResourceNotFoundException;
import pe.edu.upc.cinewin.models.PeliculaModel;
import pe.edu.upc.cinewin.repositories.PeliculaRepository;
import pe.edu.upc.cinewin.services.PeliculaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculaServiceIMP implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public PeliculaDTO crearPelicula(PeliculaDTO peliculaDTO) {
        //Convertir de DTO a entidad
        PeliculaModel pelicula = mapearEntidad(peliculaDTO);

        //Inicializamos una nueva película
        PeliculaModel nuevaPelicula = peliculaRepository.save(pelicula);

        //Convertimos de entidad a DTO
        PeliculaDTO peliculaResponse = mapearDTO(nuevaPelicula);

        return peliculaResponse;
    }

    @Override
    public List<PeliculaDTO> obtenerPeliculas() {
        List<PeliculaModel> peliculas = peliculaRepository.findAll();
        return peliculas.stream().map(pelicula -> mapearDTO(pelicula)).collect(Collectors.toList());
    }

    @Override
    public PeliculaDTO obtenerPeliculaPorID(Integer id) {
        PeliculaModel pelicula = peliculaRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Pelicula","id",id));
        return mapearDTO(pelicula);
    }

    @Override
    public PeliculaDTO actualizarPelicula(PeliculaDTO peliculaDTO, Integer id) {
        PeliculaModel pelicula = peliculaRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Pelicula","id",id));

        pelicula.setNombre(peliculaDTO.getNombre());
        pelicula.setDescripcion(peliculaDTO.getDescripcion());
        pelicula.setDuracion(peliculaDTO.getDuracion());
        pelicula.setFechaEstreno(peliculaDTO.getFechaEstreno());
        pelicula.setRating(peliculaDTO.getRating());
        pelicula.setLinkTrailer(peliculaDTO.getLinkTrailer());
        pelicula.setRutaPortada(peliculaDTO.getRutaPortada());

        PeliculaModel peliculaActualizada = peliculaRepository.save(pelicula);
        return mapearDTO(peliculaActualizada);
    }

    @Override
    public void eliminarPelicula(Integer id) {
        PeliculaModel pelicula = peliculaRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Pelicula","id",id));
        peliculaRepository.delete(pelicula);
    }

    //Convierte Entidad a DTO
    private PeliculaDTO mapearDTO(PeliculaModel peliculaModel){
        PeliculaDTO peliculaDTO = new PeliculaDTO();

        peliculaDTO.setId(peliculaModel.getId());
        peliculaDTO.setNombre(peliculaModel.getNombre());
        peliculaDTO.setDescripcion(peliculaModel.getDescripcion());
        peliculaDTO.setDuracion(peliculaModel.getDuracion());
        peliculaDTO.setFechaEstreno(peliculaModel.getFechaEstreno());
        peliculaDTO.setRating(peliculaModel.getRating());
        peliculaDTO.setLinkTrailer(peliculaModel.getLinkTrailer());
        peliculaDTO.setRutaPortada(peliculaModel.getRutaPortada());
        return peliculaDTO;
    }

    //Convierte DTO a Entidad
    private PeliculaModel mapearEntidad(PeliculaDTO peliculaDTO){
        PeliculaModel pelicula = new PeliculaModel();

        pelicula.setId(peliculaDTO.getId());
        pelicula.setNombre(peliculaDTO.getNombre());
        pelicula.setDescripcion(peliculaDTO.getDescripcion());
        pelicula.setDuracion(peliculaDTO.getDuracion());
        pelicula.setFechaEstreno(peliculaDTO.getFechaEstreno());
        pelicula.setRating(peliculaDTO.getRating());
        pelicula.setLinkTrailer(peliculaDTO.getLinkTrailer());
        pelicula.setRutaPortada(peliculaDTO.getRutaPortada());

        return pelicula;
    }
}
