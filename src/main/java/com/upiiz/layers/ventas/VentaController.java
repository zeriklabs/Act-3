package com.upiiz.layers.ventas;

import com.upiiz.layers.ventas.dto.NuevaVentaDto;
import com.upiiz.layers.ventas.dto.VentaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Capa de presentación - {JSON} - Navegador, Cliente REST (Insomnia, Postman)
@RestController
@RequestMapping("/ventas")
public class VentaController {

    private VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    // POST /ventas — Crear nueva venta
    @PostMapping
    public ResponseEntity<VentaDto> save(@RequestBody NuevaVentaDto nuevaVentaDto) {
        VentaDto ventaDto = ventaService.save(nuevaVentaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaDto);
    }

    // GET /ventas — Obtener todas las ventas
    @GetMapping
    public ResponseEntity<List<VentaDto>> findAll() {
        List<VentaDto> ventas = ventaService.findAll();
        return ResponseEntity.ok(ventas);
    }

    // PUT /ventas/{id} — Actualizar una venta
    @PutMapping("/{id}")
    public ResponseEntity<VentaDto> update(
            @PathVariable Long id,
            @RequestBody NuevaVentaDto updateVentaDto) {
        VentaDto ventaDto = ventaService.update(id, updateVentaDto);
        return ResponseEntity.ok(ventaDto);
    }

    // DELETE /ventas/{id} — Eliminar una venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ventaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
