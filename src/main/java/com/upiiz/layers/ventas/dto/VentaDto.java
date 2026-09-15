package com.upiiz.layers.ventas.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

// DTO de respuesta para Venta
public class VentaDto {
    private Long id;
    private LocalDate fecha;
    private Long clienteId;
    private BigDecimal total;

    public VentaDto() {}

    public VentaDto(Long id, LocalDate fecha, Long clienteId, BigDecimal total) {
        this.id = id;
        this.fecha = fecha;
        this.clienteId = clienteId;
        this.total = total;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
