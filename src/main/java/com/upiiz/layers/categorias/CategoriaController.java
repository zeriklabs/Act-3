package com.upiiz.layers.categorias;

import com.upiiz.layers.categorias.dto.CategoriaDto;
import com.upiiz.layers.categorias.dto.NuevaCategoriaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Capa de presentación - {JSON} - Navegador, Cliente REST (Insomnia, Postman)
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // POST /categorias — Crear nueva categoría
    @PostMapping
    public ResponseEntity<CategoriaDto> save(@RequestBody NuevaCategoriaDto nuevaCategoriaDto) {
        CategoriaDto categoriaDto = categoriaService.save(nuevaCategoriaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDto);
    }

    // GET /categorias — Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {
        List<CategoriaDto> categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    // PUT /categorias/{id} — Actualizar una categoría
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(
            @PathVariable Long id,
            @RequestBody NuevaCategoriaDto updateCategoriaDto) {
        CategoriaDto categoriaDto = categoriaService.update(id, updateCategoriaDto);
        return ResponseEntity.ok(categoriaDto);
    }

    // DELETE /categorias/{id} — Eliminar una categoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
