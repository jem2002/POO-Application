package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Facultad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_decano")
    private Persona decano;

    public Facultad(){
    }

    public Facultad(String nombre, Persona decano){
        this.nombre = nombre;
        this.decano = decano;
    }

    public Integer getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Persona getDecano(){
        return decano;
    }

    public void setDecano(Persona decano) {
        this.decano = decano;
    }

    @Override
    public String toString(){
        return "Facultad{id=" + id +
        ", nombre=" + nombre +
        ", decano=" + (decano != null ? decano.getNombres() : "Sin decano")+ "}";
    }
}

