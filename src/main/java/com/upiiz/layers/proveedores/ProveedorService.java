package com.upiiz.layers.proveedores;

import com.upiiz.layers.proveedores.dto.NuevoProveedorDto;
import com.upiiz.layers.proveedores.dto.ProveedorDto;

import java.util.List;

// Contrato - capa de negocio para proveedores
public interface ProveedorService {
    ProveedorDto save(NuevoProveedorDto nuevoProveedorDto);
    List<ProveedorDto> findAll();
    ProveedorDto update(Long id, NuevoProveedorDto updateProveedorDto);
    void delete(Long id);
}
