package com.upiiz.layers.categorias.entity;

import jakarta.persistence.*;

@Entity
@Table(name="categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    // 1. Constructor vacío (Requerido por JPA/Hibernate)
    public CategoriaEntity() {
    }

    // 2. Constructor para crear nuevas entidades (sin id, ya que es autogenerado)
    public CategoriaEntity(String descripcion) {
        this.descripcion = descripcion;
    }

    // 3. Constructor completo
    public CategoriaEntity(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
