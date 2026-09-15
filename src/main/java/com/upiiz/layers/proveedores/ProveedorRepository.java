package com.upiiz.layers.proveedores;

import com.upiiz.layers.proveedores.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Capa de persistencia - ORM - JPA
@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {

    // Buscar proveedor por email (único)
    Optional<ProveedorEntity> findByEmailIgnoreCase(String email);

    @Override
    Optional<ProveedorEntity> findById(Long id);
}
