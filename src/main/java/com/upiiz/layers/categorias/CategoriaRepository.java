package com.upiiz.layers.categorias;

import com.upiiz.layers.categorias.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//capa de persistencia - ORM - JPA - Mongoose, typeORM, Sequelize
//Extends - Herencia
//Implements - Implementar una interfaz
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    // Buscar categoria por descripcion ignorando mayúsculas/minúsculas
    Optional<CategoriaEntity> findByDescripcionIgnoreCase(String descripcion);

    @Override
    Optional<CategoriaEntity> findById(Long aLong);
}
