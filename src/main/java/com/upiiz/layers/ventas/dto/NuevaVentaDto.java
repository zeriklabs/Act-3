package com.upiiz.layers.ventas.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

// DTO de petición para crear/actualizar una Venta
public class NuevaVentaDto {
    private LocalDate fecha;
    private Long clienteId;
    private BigDecimal total;

    public NuevaVentaDto() {}

    public NuevaVentaDto(LocalDate fecha, Long clienteId, BigDecimal total) {
        this.fecha = fecha;
        this.clienteId = clienteId;
        this.total = total;
    }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
