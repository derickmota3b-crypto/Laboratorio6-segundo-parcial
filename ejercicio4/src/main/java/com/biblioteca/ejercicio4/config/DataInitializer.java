package com.biblioteca.ejercicio4.config;

import com.biblioteca.ejercicio4.model.Libro;
import com.biblioteca.ejercicio4.repository.LibroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private final LibroRepository libroRepository;
    
    public DataInitializer(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Crear 5 libros iniciales
        Libro libro1 = new Libro(null, "Cien años de soledad", "Gabriel García Márquez", "978-8401405232", 1967, "Disponible");
        Libro libro2 = new Libro(null, "Don Quijote de la Mancha", "Miguel de Cervantes", "978-8401380018", 1605, "Disponible");
        Libro libro3 = new Libro(null, "El Quijote Volumen 2", "Miguel de Cervantes", "978-8401380025", 1615, "Prestado");
        Libro libro4 = new Libro(null, "Crimen y Castigo", "Fiódor Dostoyevski", "978-8408046509", 1866, "Disponible");
        Libro libro5 = new Libro(null, "Orgullo y Prejuicio", "Jane Austen", "978-8408041115", 1813, "Disponible");
        
        libroRepository.save(libro1);
        libroRepository.save(libro2);
        libroRepository.save(libro3);
        libroRepository.save(libro4);
        libroRepository.save(libro5);
        
        System.out.println("✓ Se han inicializado 5 libros automáticamente");
    }
}