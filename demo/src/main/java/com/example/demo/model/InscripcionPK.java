package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class InscripcionPK implements Serializable {

    @Column(name = "id_estudiante", nullable = false)
    private Long idEstudiante;

    @Column(name = "id_curso", nullable = false)
    private Long idCurso;

    public InscripcionPK() {
    }

    public InscripcionPK(Long idEstudiante, Long idCurso) {
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscripcionPK that = (InscripcionPK) o;

        if (idEstudiante != null ? !idEstudiante.equals(that.idEstudiante) : that.idEstudiante != null) return false;
        return idCurso != null ? idCurso.equals(that.idCurso) : that.idCurso == null;
    }

    @Override
    public int hashCode() {
        int result = idEstudiante != null ? idEstudiante.hashCode() : 0;
        result = 31 * result + (idCurso != null ? idCurso.hashCode() : 0);
        return result;
    }
    
}
