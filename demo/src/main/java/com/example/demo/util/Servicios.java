package com.example.demo.util;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface Servicios<T> {
    T buscarPorId(Long id);
    List<T> listarTodos();
    void guardar(T entidad);
    void eliminar(Long id);
}