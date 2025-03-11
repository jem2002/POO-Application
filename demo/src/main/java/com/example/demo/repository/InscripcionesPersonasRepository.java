package com.example.demo.repository;

import com.example.demo.model.InscripcionesPersonas;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionesPersonasRepository extends JpaRepository<InscripcionesPersonas, Long> {

    Optional<InscripcionesPersonas> findTopByOrderByIdDesc();
}
