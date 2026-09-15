package com.upiiz.layers.clientes;

import com.upiiz.layers.clientes.dto.ClienteDto;
import com.upiiz.layers.clientes.dto.NuevoClienteDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Capa de presentación - {JSON} - Navegador, Cliente REST (Insomnia, Postman)
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // POST /clientes — Crear nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteDto> save(@RequestBody NuevoClienteDto nuevoClienteDto) {
        ClienteDto clienteDto = clienteService.save(nuevoClienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDto);
    }

    // GET /clientes — Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<ClienteDto>> findAll() {
        List<ClienteDto> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    // PUT /clientes/{id} — Actualizar un cliente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> update(
            @PathVariable Long id,
            @RequestBody NuevoClienteDto updateClienteDto) {
        ClienteDto clienteDto = clienteService.update(id, updateClienteDto);
        return ResponseEntity.ok(clienteDto);
    }

    // DELETE /clientes/{id} — Eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
