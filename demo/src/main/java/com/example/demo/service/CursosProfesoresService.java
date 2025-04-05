package com.example.demo.service;

import com.example.demo.model.CursosProfesores;
import com.example.demo.repository.CursosProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursosProfesoresService {

    @Autowired
    private CursosProfesoresRepository repository;

    public List<CursosProfesores> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<CursosProfesores> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public CursosProfesores guardar(CursosProfesores cursosProfesores) {
        return repository.save(cursosProfesores);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}