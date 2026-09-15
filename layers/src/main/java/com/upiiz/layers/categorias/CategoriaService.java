package com.upiiz.layers.categorias;

import com.upiiz.layers.categorias.dto.CategoriaDto;
import com.upiiz.layers.categorias.dto.NuevaCategoriaDto;

import java.util.List;

//Contrato - Entre Programadores
public interface CategoriaService {
    CategoriaDto save(NuevaCategoriaDto nuevaCategoriaDto);
    List<CategoriaDto> findAll();
    CategoriaDto update(Long id, NuevaCategoriaDto updateCategoriaDto);
    void delete(Long id);
}
