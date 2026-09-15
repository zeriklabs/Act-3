package com.upiiz.layers.facturas;

import com.upiiz.layers.facturas.dto.FacturaDto;
import com.upiiz.layers.facturas.dto.NuevaFacturaDto;

import java.util.List;

// Contrato - capa de negocio para facturas
public interface FacturaService {
    FacturaDto save(NuevaFacturaDto nuevaFacturaDto);
    List<FacturaDto> findAll();
    FacturaDto update(Long id, NuevaFacturaDto updateFacturaDto);
    void delete(Long id);
}
