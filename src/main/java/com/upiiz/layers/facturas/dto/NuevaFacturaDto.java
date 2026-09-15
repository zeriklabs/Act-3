package com.upiiz.layers.facturas.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

// DTO de petición para crear/actualizar una Factura
public class NuevaFacturaDto {
    private LocalDate fecha;
    private Long ventaId;
    private BigDecimal total;
    private String estado;

    public NuevaFacturaDto() {}

    public NuevaFacturaDto(LocalDate fecha, Long ventaId, BigDecimal total, String estado) {
        this.fecha = fecha;
        this.ventaId = ventaId;
        this.total = total;
        this.estado = estado;
    }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Long getVentaId() { return ventaId; }
    public void setVentaId(Long ventaId) { this.ventaId = ventaId; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
