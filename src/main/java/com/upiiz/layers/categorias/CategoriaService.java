package com.upiiz.layers.categorias;

import com.upiiz.layers.categorias.dto.NuevaCategoriaDto;
import com.upiiz.layers.categorias.dto.CategoriaDto;
import java.util.List;

//Contrato - entre programadores
public interface CategoriaService {
    //Jefe especifica los detalles del contrato
    //Request - Nombre, rfc, email
    //Response - Id, nombre, rfc, email
    //Request - descripcion
    //Guarde la categoria
    CategoriaDto save(NuevaCategoriaDto nuevaCategoriaDto);
    //Muestre las catgorias
    List<CategoriaDto> findAll();
    //Que actualice una categoria
    CategoriaDto update(Long id, NuevaCategoriaDto updateCategoriaDto);
    //Borre una categoria
    void delete(Long id);
}
