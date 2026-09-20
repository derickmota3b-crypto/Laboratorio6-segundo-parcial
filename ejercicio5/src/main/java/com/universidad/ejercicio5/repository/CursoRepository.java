package com.universidad.ejercicio5.repository;

import com.universidad.ejercicio5.model.Curso;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CursoRepository {
    private final List<Curso> cursos = new ArrayList<>();
    private Long secuenciaId = 1L;

    public List<Curso> findAll() {
        return new ArrayList<>(cursos);
    }

    public Optional<Curso> findById(Long id) {
        return cursos.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Optional<Curso> findByCodigo(String codigo) {
        return cursos.stream().filter(c -> c.getCodigo().equalsIgnoreCase(codigo)).findFirst();
    }

    public Curso save(Curso curso) {
        if (curso.getId() == null) {
            curso.setId(secuenciaId++);
            cursos.add(curso);
        } else {
            findById(curso.getId()).ifPresent(c -> {
                c.setNombre(curso.getNombre());
                c.setCodigo(curso.getCodigo());
                c.setCreditos(curso.getCreditos());
                c.setEstado(curso.getEstado());
            });
        }
        return curso;
    }

    public boolean deleteById(Long id) {
        return cursos.removeIf(c -> c.getId().equals(id));
    }
}
