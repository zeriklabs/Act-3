package com.upiiz.layers.facturas;

import com.upiiz.layers.facturas.entity.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Capa de persistencia - ORM - JPA
@Repository
public interface FacturaRepository extends JpaRepository<FacturaEntity, Long> {

    // Buscar facturas por ventaId
    List<FacturaEntity> findByVentaId(Long ventaId);

    // Buscar facturas por estado (PENDIENTE, PAGADA, CANCELADA)
    List<FacturaEntity> findByEstado(String estado);

    @Override
    Optional<FacturaEntity> findById(Long id);
}
