package com.biblioteca.controller;

import com.biblioteca.ejercicio4.model.Libro;
import com.biblioteca.ejercicio4.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerLibros(@RequestParam(required = false) String titulo) {
        return ResponseEntity.ok(service.listar(titulo));
    }

    @PostMapping
    public ResponseEntity<Libro> registrarLibro(@RequestBody Libro libro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return service.actualizar(id, libro)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
