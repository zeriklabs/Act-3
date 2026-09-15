package com.upiiz.layers.clientes;

import com.upiiz.layers.clientes.dto.ClienteDto;
import com.upiiz.layers.clientes.dto.NuevoClienteDto;

import java.util.List;

// Contrato - capa de negocio para clientes
public interface ClienteService {
    ClienteDto save(NuevoClienteDto nuevoClienteDto);
    List<ClienteDto> findAll();
    ClienteDto update(Long id, NuevoClienteDto updateClienteDto);
    void delete(Long id);
}
