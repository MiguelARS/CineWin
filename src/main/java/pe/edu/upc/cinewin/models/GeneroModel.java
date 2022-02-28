package pe.edu.upc.cinewin.models;

import lombok.Data;

import javax.persistence.*;


@Table(name = "genero")
@Data
@Entity
public class GeneroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGenero",nullable = false,unique = true)
    private Integer id;

    private String genero;
}
