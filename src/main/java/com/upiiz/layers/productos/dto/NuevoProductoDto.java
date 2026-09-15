package com.upiiz.layers.productos.dto;

import java.math.BigDecimal;

// DTO de petición — datos que recibe el servidor del cliente
public class NuevoProductoDto {

    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private Long categoriaId;

    // Constructores
    public NuevoProductoDto() {
    }

    public NuevoProductoDto(String nombre, BigDecimal precio, Integer stock, Long categoriaId) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoriaId = categoriaId;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
}
