package com.example.demo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_programa")
    private Programa programa;

    @Column(nullable = false)
    private Boolean activo;

    public Curso(){
    }

    public Curso(String nombre, Programa programa, Boolean activo){
        this.nombre = nombre;
        this.programa = programa;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Curso{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", programa=" + (programa != null ? programa.getNombre() : "Sin programa") +
            ", activo=" + activo +
            '}';
    }

}
