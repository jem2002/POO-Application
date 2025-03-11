package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "inscripciones")
public class Inscripcion implements Serializable{

    @EmbeddedId
    private InscripcionPK id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_curso", insertable = false, updatable = false)
    private Curso curso;
    
    @Column(name = "año",nullable = false)
    private Integer anno;

    @Column(name = "semestre",nullable = false)
    private Integer semestre;


    public Inscripcion(){
    }

    public Inscripcion(Estudiante estudiante, Curso curso, Integer anno, Integer semestre) {
    this.estudiante = Objects.requireNonNull(estudiante, "Estudiante no puede ser nulo");
    this.curso = Objects.requireNonNull(curso, "Curso no puede ser nulo");
    this.id = new InscripcionPK(estudiante.getId(), curso.getId());
    this.anno = anno;
    this.semestre = semestre;
}

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return String.format(
            "Inscripcion [estudiante=%s, curso=%s, año=%d, semestre=%d]",
            (estudiante != null ? estudiante.getNombres() : "null"),
            (curso != null ? curso.getNombre() : "null"),
            anno,
            semestre
        );
    }
}
