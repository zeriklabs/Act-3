package com.upiiz.layers.ventas.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "venta")
public class VentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    // Referencia al cliente (solo el id)
    private Long clienteId;

    private BigDecimal total;

    // Constructor vacío (requerido por JPA/Hibernate)
    public VentaEntity() {
    }

    // Constructor sin id
    public VentaEntity(LocalDate fecha, Long clienteId, BigDecimal total) {
        this.fecha = fecha;
        this.clienteId = clienteId;
        this.total = total;
    }

    // Constructor completo
    public VentaEntity(Long id, LocalDate fecha, Long clienteId, BigDecimal total) {
        this.id = id;
        this.fecha = fecha;
        this.clienteId = clienteId;
        this.total = total;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
