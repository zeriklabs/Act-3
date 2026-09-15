package com.upiiz.layers.ventas;

import com.upiiz.layers.ventas.entity.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Capa de persistencia - ORM - JPA
@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Long> {

    // Buscar ventas por clienteId
    List<VentaEntity> findByClienteId(Long clienteId);

    @Override
    Optional<VentaEntity> findById(Long id);
}
