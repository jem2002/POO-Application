package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CursoProfesorPK implements Serializable {

    @Column(name = "id_profesor", nullable = false)
    private Long idProfesor;

    @Column(name = "id_curso", nullable = false)
    private Long idCurso;

    public CursoProfesorPK() {
    }

    public CursoProfesorPK(Long idProfesor, Long idCurso) {
        this.idProfesor = idProfesor;
        this.idCurso = idCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoProfesorPK that = (CursoProfesorPK) o;
        return Objects.equals(idProfesor, that.idProfesor) &&
                Objects.equals(idCurso, that.idCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfesor, idCurso);
    }
}