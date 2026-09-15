package com.upiiz.layers.categorias;

import com.upiiz.layers.categorias.dto.CategoriaDto;
import com.upiiz.layers.categorias.dto.NuevaCategoriaDto;
import com.upiiz.layers.categorias.entities.CategoriaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

//Capa de Negocio
@Service
public class CategoriaServiceImpl implements CategoriaService {


    private CategoriaRepository categoriaRepository;

    CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    @Override
    public CategoriaDto save(NuevaCategoriaDto nuevaCategoriaDto) {
        categoriaRepository.findByDescripcionIgnoreCase(nuevaCategoriaDto.getDescripcion()).ifPresent(e->{
            throw new IllegalArgumentException("La categoria ya existe");
        });
        CategoriaEntity nuevaCategoria = new CategoriaEntity(nuevaCategoriaDto.getDescripcion());
        CategoriaEntity categoriaGuardada=categoriaRepository.save(nuevaCategoria);
        return new CategoriaDto(categoriaGuardada.getId(),categoriaGuardada.getDescripcion());
    }

    @Override
    public List<CategoriaDto> findAll() {
        return List.of();
    }

    @Override
    public CategoriaDto update(Long id, NuevaCategoriaDto updateCategoriaDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }



}
