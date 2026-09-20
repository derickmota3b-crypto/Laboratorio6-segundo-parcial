package com.universidad.ejercicio5.service;

import com.universidad.ejercicio5.model.Curso;
import com.universidad.ejercicio5.repository.CursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> listarTodos() {
        return repository.findAll();
    }

    public Optional<Curso> buscarPorCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }

    public Curso crear(Curso curso) {
        return repository.save(curso);
    }

    public Optional<Curso> actualizar(Long id, Curso cursoActualizado) {
        return repository.findById(id).map(curso -> {
            cursoActualizado.setId(id);
            return repository.save(cursoActualizado);
        });
    }

    public boolean eliminar(Long id) {
        return repository.deleteById(id);
    }
}
