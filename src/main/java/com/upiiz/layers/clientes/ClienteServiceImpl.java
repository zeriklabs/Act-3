package com.upiiz.layers.clientes;

import com.upiiz.layers.clientes.dto.ClienteDto;
import com.upiiz.layers.clientes.dto.NuevoClienteDto;
import com.upiiz.layers.clientes.entity.ClienteEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Capa de negocio
@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDto save(NuevoClienteDto nuevoClienteDto) {
        // Regla de negocio: No se debe duplicar el email del cliente
        Optional<ClienteEntity> clienteExistente =
                clienteRepository.findByEmailIgnoreCase(nuevoClienteDto.getEmail());

        if (clienteExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un cliente con el email: " + nuevoClienteDto.getEmail());
        }

        ClienteEntity nuevaEntidad = new ClienteEntity(
                nuevoClienteDto.getNombre(),
                nuevoClienteDto.getEmail(),
                nuevoClienteDto.getTelefono()
        );
        ClienteEntity guardado = clienteRepository.save(nuevaEntidad);

        return new ClienteDto(guardado.getId(), guardado.getNombre(), guardado.getEmail(), guardado.getTelefono());
    }

    @Override
    public List<ClienteDto> findAll() {
        return clienteRepository.findAll()
                .stream()
                .map(e -> new ClienteDto(e.getId(), e.getNombre(), e.getEmail(), e.getTelefono()))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDto update(Long id, NuevoClienteDto updateClienteDto) {
        ClienteEntity entidad = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con id: " + id));

        entidad.setNombre(updateClienteDto.getNombre());
        entidad.setEmail(updateClienteDto.getEmail());
        entidad.setTelefono(updateClienteDto.getTelefono());

        ClienteEntity actualizado = clienteRepository.save(entidad);
        return new ClienteDto(actualizado.getId(), actualizado.getNombre(), actualizado.getEmail(), actualizado.getTelefono());
    }

    @Override
    public void delete(Long id) {
        clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con id: " + id));
        clienteRepository.deleteById(id);
    }
}
