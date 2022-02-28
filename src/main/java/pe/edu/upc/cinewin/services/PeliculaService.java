package pe.edu.upc.cinewin.services;

import pe.edu.upc.cinewin.dto.PeliculaDTO;

import java.util.List;

public interface PeliculaService {
    public PeliculaDTO crearPelicula(PeliculaDTO peliculaDTO);
    public List<PeliculaDTO> obtenerPeliculas();
    public PeliculaDTO obtenerPeliculaPorID(Integer id);
    public PeliculaDTO actualizarPelicula(PeliculaDTO peliculaDTO, Integer id);
    public void eliminarPelicula(Integer id);
}
