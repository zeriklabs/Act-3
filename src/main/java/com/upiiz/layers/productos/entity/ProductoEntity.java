package com.upiiz.layers.productos.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private BigDecimal precio;

    private Integer stock;

    // Referencia a la categoría (solo el id, sin relación JPA compleja)
    private Long categoriaId;

    // Constructor vacío (requerido por JPA/Hibernate)
    public ProductoEntity() {
    }

    // Constructor sin id (para crear nuevos productos)
    public ProductoEntity(String nombre, BigDecimal precio, Integer stock, Long categoriaId) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoriaId = categoriaId;
    }

    // Constructor completo
    public ProductoEntity(Long id, String nombre, BigDecimal precio, Integer stock, Long categoriaId) {
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
