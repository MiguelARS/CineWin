package pe.edu.upc.cinewin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.cinewin.dto.PeliculaDTO;
import pe.edu.upc.cinewin.services.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    public ResponseEntity<PeliculaDTO> guardarPelicula(@RequestBody PeliculaDTO peliculaDTO){
        return new ResponseEntity<>(peliculaService.crearPelicula(peliculaDTO), HttpStatus.CREATED);
    }
}
