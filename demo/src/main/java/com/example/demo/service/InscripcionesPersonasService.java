package com.example.demo.service;

import com.example.demo.model.InscripcionesPersonas;
import com.example.demo.repository.InscripcionesPersonasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InscripcionesPersonasService {

    private final InscripcionesPersonasRepository repository;

    public InscripcionesPersonasService(InscripcionesPersonasRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public InscripcionesPersonas guardarInscripcion(InscripcionesPersonas inscripcion) {
        InscripcionesPersonas guardada = repository.save(inscripcion);
        guardada.guardarPersistencia();
        return guardada;
    }

    @Transactional(readOnly = true)
    public InscripcionesPersonas obtenerUltimaInscripcion() {
        return repository.findTopByOrderByIdDesc()
            .orElseThrow(() -> new RuntimeException("No hay inscripciones registradas"));
    }

    @Transactional
    public void eliminarInscripcion(Long id) {
        repository.deleteById(id);
    }
}