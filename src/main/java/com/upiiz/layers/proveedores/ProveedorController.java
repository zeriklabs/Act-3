package com.upiiz.layers.proveedores;

import com.upiiz.layers.proveedores.dto.NuevoProveedorDto;
import com.upiiz.layers.proveedores.dto.ProveedorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Capa de presentación - {JSON} - Navegador, Cliente REST (Insomnia, Postman)
@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    // POST /proveedores — Crear nuevo proveedor
    @PostMapping
    public ResponseEntity<ProveedorDto> save(@RequestBody NuevoProveedorDto nuevoProveedorDto) {
        ProveedorDto proveedorDto = proveedorService.save(nuevoProveedorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedorDto);
    }

    // GET /proveedores — Obtener todos los proveedores
    @GetMapping
    public ResponseEntity<List<ProveedorDto>> findAll() {
        List<ProveedorDto> proveedores = proveedorService.findAll();
        return ResponseEntity.ok(proveedores);
    }

    // PUT /proveedores/{id} — Actualizar un proveedor
    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDto> update(
            @PathVariable Long id,
            @RequestBody NuevoProveedorDto updateProveedorDto) {
        ProveedorDto proveedorDto = proveedorService.update(id, updateProveedorDto);
        return ResponseEntity.ok(proveedorDto);
    }

    // DELETE /proveedores/{id} — Eliminar un proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        proveedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
