package com.upiiz.layers.productos.dto;

import java.math.BigDecimal;

// DTO de respuesta — datos que se envían al cliente
public class ProductoDto {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private Long categoriaId;

    // Constructores
    public ProductoDto() {
    }

    public ProductoDto(Long id, String nombre, BigDecimal precio, Integer stock, Long categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoriaId = categoriaId;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
}
