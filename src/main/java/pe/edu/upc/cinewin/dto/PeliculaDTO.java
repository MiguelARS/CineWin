package pe.edu.upc.cinewin.dto;

import lombok.Data;
import java.util.Date;

@Data
public class PeliculaDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer rating;
    private Date fechaEstreno;
    private String linkTrailer;
    private String rutaPortada;
    private String duracion;
}
