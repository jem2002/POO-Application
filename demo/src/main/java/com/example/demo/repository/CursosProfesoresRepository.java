package com.example.demo.repository;

import com.example.demo.model.CursosProfesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosProfesoresRepository extends JpaRepository<CursosProfesores, Long> {
    
}
