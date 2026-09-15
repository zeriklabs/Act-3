package com.upiiz.layers.categorias.dto;

public class CategoriaDto {
    private Long id;
    private String descripcion;

    public CategoriaDto() {
    }

    public CategoriaDto(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
