package com.biblioteca.ejercicio4.repository;

import com.biblioteca.ejercicio4.model.Libro;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LibroRepository {
    private final List<Libro> libros = new ArrayList<>();
    private Long secuenciaId = 1L;

    public List<Libro> findAll() {
        return new ArrayList<>(libros);
    }

    public List<Libro> findByTitulo(String titulo) {
        return libros.stream()
                .filter(l -> l.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Libro> findById(Long id) {
        return libros.stream().filter(l -> l.getId().equals(id)).findFirst();
    }

    public Libro save(Libro libro) {
        if (libro.getId() == null) {
            libro.setId(secuenciaId++);
            libros.add(libro);
        } else {
            findById(libro.getId()).ifPresent(l -> {
                l.setTitulo(libro.getTitulo());
                l.setAutor(libro.getAutor());
                l.setIsbn(libro.getIsbn());
                l.setAnioPublicacion(libro.getAnioPublicacion());
                l.setEstado(libro.getEstado());
            });
        }
        return libro;
    }

    public boolean deleteById(Long id) {
        return libros.removeIf(l -> l.getId().equals(id));
    }
}
