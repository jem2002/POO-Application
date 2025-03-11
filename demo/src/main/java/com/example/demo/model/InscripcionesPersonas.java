package com.example.demo.model;

import com.example.demo.util.Serializador;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "inscripciones_personas")
public class InscripcionesPersonas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "inscripcion_id")
    private List<Persona> personas = new ArrayList<>();

    private static final String DATA_FILE = "inscripciones.dat";
    private static final String KEY_FILE = "clave_inscripciones.key";
    private transient final Serializador serializador = new Serializador(DATA_FILE, KEY_FILE);

    public InscripcionesPersonas() {
        this.personas = serializador.cargarDatos();
    }

    public void inscribirPersona(Persona persona) {
        if (personas.stream().noneMatch(p -> p.getId().equals(persona.getId()))) {
            personas.add(persona);
            guardarPersistencia();
            System.out.println("Persona inscrita: " + persona);
        }
    }

    @PostPersist
    @PostUpdate
    public void guardarPersistencia() {
        serializador.guardarDatos(personas);
    }

    public void actualizarPersona(Persona personaActualizada) {
        personas.replaceAll(p -> 
            p.getId().equals(personaActualizada.getId()) ? personaActualizada : p
        );
        guardarPersistencia();
    }

    public void eliminarPersona(Long id) {
        personas.removeIf(p -> p.getId().equals(id));
        guardarPersistencia();
    }

    public Optional<Persona> buscarPorId(Long id) {
        return personas.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
    }

    // Getters y setters
    public List<Persona> getPersonas() {
        return new ArrayList<>(personas);
    }
}