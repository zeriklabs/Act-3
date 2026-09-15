package com.upiiz.layers.productos;

import com.upiiz.layers.productos.dto.NuevoProductoDto;
import com.upiiz.layers.productos.dto.ProductoDto;

import java.util.List;

// Contrato - capa de negocio para productos
public interface ProductoService {
    // Guardar un producto
    ProductoDto save(NuevoProductoDto nuevoProductoDto);

    // Mostrar todos los productos
    List<ProductoDto> findAll();

    // Actualizar un producto
    ProductoDto update(Long id, NuevoProductoDto updateProductoDto);

    // Borrar un producto
    void delete(Long id);
}
