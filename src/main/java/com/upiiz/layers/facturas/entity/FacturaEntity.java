package com.upiiz.layers.facturas.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "factura")
public class FacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    // Referencia a la venta (solo el id)
    private Long ventaId;

    private BigDecimal total;

    // Estado: PENDIENTE, PAGADA, CANCELADA
    private String estado;

    // Constructor vacío (requerido por JPA/Hibernate)
    public FacturaEntity() {
    }

    // Constructor sin id
    public FacturaEntity(LocalDate fecha, Long ventaId, BigDecimal total, String estado) {
        this.fecha = fecha;
        this.ventaId = ventaId;
        this.total = total;
        this.estado = estado;
    }

    // Constructor completo
    public FacturaEntity(Long id, LocalDate fecha, Long ventaId, BigDecimal total, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.ventaId = ventaId;
        this.total = total;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Long getVentaId() { return ventaId; }
    public void setVentaId(Long ventaId) { this.ventaId = ventaId; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
