package com.upiiz.layers.productos;

import com.upiiz.layers.productos.dto.NuevoProductoDto;
import com.upiiz.layers.productos.dto.ProductoDto;
import com.upiiz.layers.productos.entity.ProductoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Capa de negocio
@Service
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoDto save(NuevoProductoDto nuevoProductoDto) {
        // Regla de negocio: No se debe duplicar el producto por nombre
        Optional<ProductoEntity> productoExistente =
                productoRepository.findByNombreIgnoreCase(nuevoProductoDto.getNombre());

        if (productoExistente.isPresent()) {
            throw new IllegalArgumentException("El producto ya existe: " + nuevoProductoDto.getNombre());
        }

        // Guardar nueva entidad
        ProductoEntity nuevaEntidad = new ProductoEntity(
                nuevoProductoDto.getNombre(),
                nuevoProductoDto.getPrecio(),
                nuevoProductoDto.getStock(),
                nuevoProductoDto.getCategoriaId()
        );
        ProductoEntity guardado = productoRepository.save(nuevaEntidad);

        return new ProductoDto(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getPrecio(),
                guardado.getStock(),
                guardado.getCategoriaId()
        );
    }

    @Override
    public List<ProductoDto> findAll() {
        return productoRepository.findAll()
                .stream()
                .map(e -> new ProductoDto(e.getId(), e.getNombre(), e.getPrecio(), e.getStock(), e.getCategoriaId()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDto update(Long id, NuevoProductoDto updateProductoDto) {
        ProductoEntity entidad = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con id: " + id));

        entidad.setNombre(updateProductoDto.getNombre());
        entidad.setPrecio(updateProductoDto.getPrecio());
        entidad.setStock(updateProductoDto.getStock());
        entidad.setCategoriaId(updateProductoDto.getCategoriaId());

        ProductoEntity actualizado = productoRepository.save(entidad);

        return new ProductoDto(
                actualizado.getId(),
                actualizado.getNombre(),
                actualizado.getPrecio(),
                actualizado.getStock(),
                actualizado.getCategoriaId()
        );
    }

    @Override
    public void delete(Long id) {
        productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con id: " + id));
        productoRepository.deleteById(id);
    }
}
