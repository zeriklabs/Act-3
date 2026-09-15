package com.upiiz.layers.categorias;


import com.upiiz.layers.categorias.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Capa de Persistencia - ORM - JPA
//Extend - Herencia
//Implements - Implementar una interfaz
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Long> {
    //Agregar más métodos
    Optional<CategoriaEntity> findByDescripcionIgnoreCase(String descripcion);
}
