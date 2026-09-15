package com.upiiz.layers.proveedores;

import com.upiiz.layers.proveedores.dto.NuevoProveedorDto;
import com.upiiz.layers.proveedores.dto.ProveedorDto;
import com.upiiz.layers.proveedores.entity.ProveedorEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Capa de negocio
@Service
public class ProveedorServiceImpl implements ProveedorService {

    private ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public ProveedorDto save(NuevoProveedorDto nuevoProveedorDto) {
        // Regla de negocio: No se debe duplicar el email del proveedor
        Optional<ProveedorEntity> proveedorExistente =
                proveedorRepository.findByEmailIgnoreCase(nuevoProveedorDto.getEmail());

        if (proveedorExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un proveedor con el email: " + nuevoProveedorDto.getEmail());
        }

        ProveedorEntity nuevaEntidad = new ProveedorEntity(
                nuevoProveedorDto.getNombre(),
                nuevoProveedorDto.getEmail(),
                nuevoProveedorDto.getTelefono()
        );
        ProveedorEntity guardado = proveedorRepository.save(nuevaEntidad);

        return new ProveedorDto(guardado.getId(), guardado.getNombre(), guardado.getEmail(), guardado.getTelefono());
    }

    @Override
    public List<ProveedorDto> findAll() {
        return proveedorRepository.findAll()
                .stream()
                .map(e -> new ProveedorDto(e.getId(), e.getNombre(), e.getEmail(), e.getTelefono()))
                .collect(Collectors.toList());
    }

    @Override
    public ProveedorDto update(Long id, NuevoProveedorDto updateProveedorDto) {
        ProveedorEntity entidad = proveedorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Proveedor no encontrado con id: " + id));

        entidad.setNombre(updateProveedorDto.getNombre());
        entidad.setEmail(updateProveedorDto.getEmail());
        entidad.setTelefono(updateProveedorDto.getTelefono());

        ProveedorEntity actualizado = proveedorRepository.save(entidad);
        return new ProveedorDto(actualizado.getId(), actualizado.getNombre(), actualizado.getEmail(), actualizado.getTelefono());
    }

    @Override
    public void delete(Long id) {
        proveedorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Proveedor no encontrado con id: " + id));
        proveedorRepository.deleteById(id);
    }
}
