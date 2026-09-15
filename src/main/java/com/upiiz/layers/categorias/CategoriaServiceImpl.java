package com.upiiz.layers.categorias;

import com.upiiz.layers.categorias.dto.CategoriaDto;
import com.upiiz.layers.categorias.dto.NuevaCategoriaDto;
import com.upiiz.layers.categorias.entity.CategoriaEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Capa de negocio
@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Implementamos métodos de CategoriaService

    @Override
    public CategoriaDto save(NuevaCategoriaDto nuevaCategoriaDto) {
        // Regla de negocio: No se debe duplicar la categoría
        // (no importa si es con mayúscula o minúscula)
        Optional<CategoriaEntity> categoriaExistente =
                categoriaRepository.findByDescripcionIgnoreCase(nuevaCategoriaDto.getDescripcion());

        if (categoriaExistente.isPresent()) {
            throw new IllegalArgumentException("La categoría ya existe: " + nuevaCategoriaDto.getDescripcion());
        }

        // Guardar nueva entidad
        CategoriaEntity nuevaEntidad = new CategoriaEntity(nuevaCategoriaDto.getDescripcion());
        CategoriaEntity guardada = categoriaRepository.save(nuevaEntidad);

        // Convertir entidad a DTO y regresar
        return new CategoriaDto(guardada.getId(), guardada.getDescripcion());
    }

    @Override
    public List<CategoriaDto> findAll() {
        // Obtener todas las categorías y convertirlas a DTO
        return categoriaRepository.findAll()
                .stream()
                .map(entidad -> new CategoriaDto(entidad.getId(), entidad.getDescripcion()))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto update(Long id, NuevaCategoriaDto updateCategoriaDto) {
        // Verificar que la categoría existe
        CategoriaEntity entidad = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada con id: " + id));

        // Actualizar descripción
        entidad.setDescripcion(updateCategoriaDto.getDescripcion());
        CategoriaEntity actualizada = categoriaRepository.save(entidad);

        return new CategoriaDto(actualizada.getId(), actualizada.getDescripcion());
    }

    @Override
    public void delete(Long id) {
        // Verificar que la categoría existe antes de borrar
        categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada con id: " + id));

        categoriaRepository.deleteById(id);
    }
}
