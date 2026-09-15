package com.upiiz.layers.facturas;

import com.upiiz.layers.facturas.dto.FacturaDto;
import com.upiiz.layers.facturas.dto.NuevaFacturaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Capa de presentación - {JSON} - Navegador, Cliente REST (Insomnia, Postman)
@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    // POST /facturas — Crear nueva factura
    @PostMapping
    public ResponseEntity<FacturaDto> save(@RequestBody NuevaFacturaDto nuevaFacturaDto) {
        FacturaDto facturaDto = facturaService.save(nuevaFacturaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaDto);
    }

    // GET /facturas — Obtener todas las facturas
    @GetMapping
    public ResponseEntity<List<FacturaDto>> findAll() {
        List<FacturaDto> facturas = facturaService.findAll();
        return ResponseEntity.ok(facturas);
    }

    // PUT /facturas/{id} — Actualizar una factura
    @PutMapping("/{id}")
    public ResponseEntity<FacturaDto> update(
            @PathVariable Long id,
            @RequestBody NuevaFacturaDto updateFacturaDto) {
        FacturaDto facturaDto = facturaService.update(id, updateFacturaDto);
        return ResponseEntity.ok(facturaDto);
    }

    // DELETE /facturas/{id} — Eliminar una factura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        facturaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
