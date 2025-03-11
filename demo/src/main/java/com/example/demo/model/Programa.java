package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Programa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "duracion", nullable = false)
    private Double duracion;
    
    @Column(name = "registro", nullable = false, length = 50)
    private Date registro;
    
    @ManyToOne
    @JoinColumn(name = "id_facultad")
    private Facultad facultad;

    public Programa(){
    }

    public Programa(String nombre, Double duracion, Date registro, Facultad facultad) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.registro = registro;
        this.facultad = facultad;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Double getDuracion(){
        return duracion;
    }

    public void setDuracion(Double duracion){
        this.duracion = duracion;
    }

    public Date getRegistro(){
        return registro;
    }

    public void setRegistro(Date registro){
        this.registro = registro;
    }

    public Facultad getFacultad(){
        return facultad;
    }

    public void setFacultad(Facultad facultad){
        this.facultad=facultad;
    }

    @Override
    public String toString() {
        return "Programa{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", duracion=" + duracion +
            ", registro='" + registro + '\'' +
            ", facultad=" + (facultad != null ? facultad.getNombre() : "Sin facultad") +
            '}';
    }
}
