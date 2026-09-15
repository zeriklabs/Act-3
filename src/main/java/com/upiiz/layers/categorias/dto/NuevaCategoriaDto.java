package com.upiiz.layers.categorias.dto;

//Transferencia de informacion
// Recibir datos del cliente
public class NuevaCategoriaDto {
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public NuevaCategoriaDto(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
