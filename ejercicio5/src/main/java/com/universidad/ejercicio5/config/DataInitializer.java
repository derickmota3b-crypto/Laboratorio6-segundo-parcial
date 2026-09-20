package com.universidad.ejercicio5.config;

import com.universidad.ejercicio5.model.Curso;
import com.universidad.ejercicio5.repository.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private final CursoRepository cursoRepository;
    
    public DataInitializer(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Crear 4 cursos iniciales
        Curso curso1 = new Curso(null, "Programación Java", "JAVA101", 4, "Activo");
        Curso curso2 = new Curso(null, "Desarrollo Web con Spring Boot", "SPRING201", 4, "Activo");
        Curso curso3 = new Curso(null, "Base de Datos SQL", "BD301", 3, "Activo");
        Curso curso4 = new Curso(null, "Estructuras de Datos", "EDAT401", 4, "Activo");
        
        cursoRepository.save(curso1);
        cursoRepository.save(curso2);
        cursoRepository.save(curso3);
        cursoRepository.save(curso4);
        
        System.out.println("✓ Se han inicializado 4 cursos automáticamente");
    }
}