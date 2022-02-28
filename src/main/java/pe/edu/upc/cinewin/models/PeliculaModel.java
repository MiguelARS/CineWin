package pe.edu.upc.cinewin.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Table(name = "pelicula",uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
@Data
@Entity
public class PeliculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPelicula",unique = true, nullable = false)
    private Integer id;

    @NotBlank
    private String nombre;
    @NotBlank
    @Column(length = 2000)
    private String descripcion;
    private Integer rating;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) //YYYY-MM-DD 2020-12-05
    private Date fechaEstreno;

    @NotBlank
    private String linkTrailer;
    @NotBlank
    private String rutaPortada;
    @NotBlank
    private String duracion;

    /*
    @NotEmpty //Debe existir al menos 1 genero en la peli
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "genero_pelicula",
            joinColumns = @JoinColumn(name="idPelicula"),
            inverseJoinColumns = @JoinColumn(name="idGenero"))
    private List<GeneroModel> generos;
    */

}