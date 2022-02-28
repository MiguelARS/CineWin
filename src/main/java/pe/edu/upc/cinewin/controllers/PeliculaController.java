package pe.edu.upc.cinewin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.cinewin.dto.PeliculaDTO;
import pe.edu.upc.cinewin.services.PeliculaService;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    public ResponseEntity<PeliculaDTO> guardarPelicula(@RequestBody PeliculaDTO peliculaDTO){
        return new ResponseEntity<>(peliculaService.crearPelicula(peliculaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PeliculaDTO> listarPeliculas(){
        return peliculaService.obtenerPeliculas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> obtenerPeliculaPorID(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(peliculaService.obtenerPeliculaPorID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> actualizarPublicacion(@RequestBody PeliculaDTO peliculaDTO,
                                                             @PathVariable(name = "id") Integer id){
        PeliculaDTO peliculaActualizada = peliculaService.actualizarPelicula(peliculaDTO,id);
        return new ResponseEntity<>(peliculaActualizada,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable(name = "id") Integer id){
        peliculaService.eliminarPelicula(id);
        return new ResponseEntity<>("Película eliminada con éxito",HttpStatus.OK);
    }
}
