package com.upiiz.layers.ventas;

import com.upiiz.layers.ventas.dto.NuevaVentaDto;
import com.upiiz.layers.ventas.dto.VentaDto;

import java.util.List;

// Contrato - capa de negocio para ventas
public interface VentaService {
    VentaDto save(NuevaVentaDto nuevaVentaDto);
    List<VentaDto> findAll();
    VentaDto update(Long id, NuevaVentaDto updateVentaDto);
    void delete(Long id);
}
