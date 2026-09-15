package com.upiiz.layers.categorias.entities;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

//Capa de Base de Datos
@Entity
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    public CategoriaEntity() {

    }

    public CategoriaEntity(String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public CategoriaEntity(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

