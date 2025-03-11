package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Estudiante extends Persona {

    @Column(nullable = false)
    private Long codigo;
    
    @ManyToOne
    @JoinColumn(name = "id_programa")
    private Programa programa;
    
    @Column(nullable = false)
    private Boolean activo;

    @Column(nullable = false)
    private Double promedio;

    public Estudiante(){}

    public Estudiante(String nombres, String apellidos, String email, Long codigo, Programa programa, Boolean activo, Double promedio){
        super(nombres, apellidos, email);
        this.codigo = codigo;
        this.programa = programa;
        this.activo = activo;
        this.promedio = promedio;
    }

    public Long getCodigo(){
        return codigo;
    }

    public void setCodigo(Long codigo){
        this.codigo = codigo;
    }

    public Programa getPrograma(){
        return programa;
    }

    public void setPrograma(Programa programa){
        this.programa = programa;
    }

    public Boolean getActivo(){
        return activo;
    }

    public void setActivo(Boolean activo){
        this.activo = activo;
    }

    public Double getPromedio(){
        return promedio;
    }

    public void setPromedio(Double promedio){
        this.promedio = promedio;
    }

    @Override
    public String toString(){
        return "Estudiante{"+
        super.toString()+
        ", codigo="+codigo+
        ", programa="+programa+
        ", activo="+activo+
        ", promedio="+promedio+
        "}";
    }

}
