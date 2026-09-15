package com.upiiz.layers.clientes;

import com.upiiz.layers.clientes.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Capa de persistencia - ORM - JPA
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    // Buscar cliente por email (único)
    Optional<ClienteEntity> findByEmailIgnoreCase(String email);

    @Override
    Optional<ClienteEntity> findById(Long id);
}
