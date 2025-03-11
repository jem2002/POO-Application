package com.example.demo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profesores")
public class Profesor extends Persona implements Serializable{
    
    @Column(name = "tipo_contrato",nullable = false, length = 50)
    private String tipoContrato;

    @ManyToOne
    @JoinColumn(name = "id_facultad")
    private Facultad facultad;

    public Profesor() {
    }

    public Profesor(String nombres, String apellidos, String email, String tipoContrato, Facultad facultad) {
        super(nombres, apellidos, email);
        this.tipoContrato = tipoContrato;
        this.facultad = facultad;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    @Override
    public String toString() {
        return "Profesor [id=" + getId() + ", nombres=" + getNombres() + ", apellidos=" + getApellidos() + ", email=" + getEmail() + ", tipoContrato=" + tipoContrato + ", facultad=" + (facultad != null ? facultad.getNombre() : "Sin facultad") + "]";
    }
}
