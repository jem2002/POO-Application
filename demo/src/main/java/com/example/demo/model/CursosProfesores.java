package com.example.demo.model;

import com.example.demo.util.Serializador;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos_profesores")
public class CursosProfesores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cursosProfesores", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CursoProfesor> listadoCursoProfesores = new ArrayList<>();

    private static final String FILE_PATH = "cursosProfesores.bin";
    private static final String KEY_PATH = "cursosProfesores.key";
    private final transient Serializador serializador = new Serializador(FILE_PATH, KEY_PATH);

    public CursosProfesores() {
        this.listadoCursoProfesores = serializador.cargarDatos();
    }

    @PostPersist
    @PostUpdate
    private void sincronizarPersistencia() {
        serializador.guardarDatos(listadoCursoProfesores);
    }

    // Métodos de negocio
    public void asignarCursoAProfesor(Profesor profesor, Curso curso, Integer anno, Integer semestre) {
        CursoProfesor relacion = new CursoProfesor(profesor, curso, anno, semestre);
        listadoCursoProfesores.add(relacion);
    }

    public List<Curso> obtenerCursosDeProfesor(Long profesorId) {
        return listadoCursoProfesores.stream()
            .filter(cp -> cp.getProfesor().getId().equals(profesorId))
            .map(CursoProfesor::getCurso)
            .toList();
    }

    public List<CursoProfesor> getListadoCursoProfesores() {
        return listadoCursoProfesores;
    }

    public void setListadoCursoProfesores(List<CursoProfesor> listadoCursoProfesores) {
        this.listadoCursoProfesores = listadoCursoProfesores;
    }

    
}