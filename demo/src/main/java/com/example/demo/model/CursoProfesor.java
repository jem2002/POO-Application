package com.example.demo.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "cursos_profesores")
public class CursoProfesor implements Serializable{
    
    @EmbeddedId
    private CursoProfesorPK id;

    @ManyToOne
    @JoinColumn(name = "id_profesor", insertable = false, updatable = false)
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "id_curso", insertable = false, updatable = false)
    private Curso curso;
    
    @Column(name = "año", nullable = false)
    private Integer anno;

    @Column(name = "semestre", nullable = false)
    private Integer semestre;

    @ManyToOne
    private CursosProfesores cursosProfesores;

    public CursoProfesor() {}

    public CursoProfesor(Profesor profesor, Curso curso, Integer anno, Integer semestre) {
        this.profesor = profesor;
        this.curso = curso;
        this.id = new CursoProfesorPK(profesor.getId(), curso.getId());
        this.anno = anno;
        this.semestre = semestre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Curso getCurso() {
        return curso;
    }

    public CursoProfesorPK getId() {
        return id;
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

    @Override
    public String toString() {
        return "CursoProfesor [profesor=" + profesor.getNombres() +
                ", curso=" + curso.getNombre() +
                ", año=" + anno +
                ", semestre=" + semestre + "]";
    }
}
