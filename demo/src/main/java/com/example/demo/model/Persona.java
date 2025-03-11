package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres",nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidos",nullable = false, length = 50)
    private String apellidos;

    @Column(name = "email",nullable = false, length = 50)
    private String email;

    public Long getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + "]";
    }

    
}