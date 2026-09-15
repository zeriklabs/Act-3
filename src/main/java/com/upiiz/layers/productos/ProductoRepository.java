package com.upiiz.layers.productos;

import com.upiiz.layers.productos.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Capa de persistencia - ORM - JPA
@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    // Buscar productos por nombre ignorando mayúsculas/minúsculas
    Optional<ProductoEntity> findByNombreIgnoreCase(String nombre);

    // Buscar todos los productos de una categoría
    List<ProductoEntity> findByCategoriaId(Long categoriaId);

    @Override
    Optional<ProductoEntity> findById(Long id);
}
