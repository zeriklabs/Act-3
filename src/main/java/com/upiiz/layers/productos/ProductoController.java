package com.upiiz.layers.productos;

import com.upiiz.layers.productos.dto.NuevoProductoDto;
import com.upiiz.layers.productos.dto.ProductoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Capa de presentación - {JSON} - Navegador, Cliente REST (Insomnia, Postman)
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // POST /productos — Crear nuevo producto
    @PostMapping
    public ResponseEntity<ProductoDto> save(@RequestBody NuevoProductoDto nuevoProductoDto) {
        ProductoDto productoDto = productoService.save(nuevoProductoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoDto);
    }

    // GET /productos — Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<ProductoDto>> findAll() {
        List<ProductoDto> productos = productoService.findAll();
        return ResponseEntity.ok(productos);
    }

    // PUT /productos/{id} — Actualizar un producto
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> update(
            @PathVariable Long id,
            @RequestBody NuevoProductoDto updateProductoDto) {
        ProductoDto productoDto = productoService.update(id, updateProductoDto);
        return ResponseEntity.ok(productoDto);
    }

    // DELETE /productos/{id} — Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
