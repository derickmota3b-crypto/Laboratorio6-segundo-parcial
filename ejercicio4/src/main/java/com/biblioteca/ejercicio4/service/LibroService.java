package com.biblioteca.ejercicio4.service;

import com.biblioteca.ejercicio4.model.Libro;
import com.biblioteca.ejercicio4.repository.LibroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public List<Libro> listar(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            return repository.findByTitulo(titulo);
        }
        return repository.findAll();
    }

    public Libro guardar(Libro libro) {
        return repository.save(libro);
    }

    public Optional<Libro> actualizar(Long id, Libro libroActualizado) {
        return repository.findById(id).map(libro -> {
            libroActualizado.setId(id);
            return repository.save(libroActualizado);
        });
    }

    public boolean eliminar(Long id) {
        return repository.deleteById(id);
    }
}
