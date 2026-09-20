package com.hotel.ejercicio6.config;

import com.hotel.ejercicio6.model.Reserva;
import com.hotel.ejercicio6.repository.ReservaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private final ReservaRepository reservaRepository;
    
    public DataInitializer(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Crear 5 reservas iniciales
        Reserva reserva1 = new Reserva(null, "Juan Pérez", "101", LocalDate.of(2026, 9, 22), LocalDate.of(2026, 9, 25), "CONFIRMADA");
        Reserva reserva2 = new Reserva(null, "María García", "205", LocalDate.of(2026, 9, 23), LocalDate.of(2026, 9, 27), "CONFIRMADA");
        Reserva reserva3 = new Reserva(null, "Carlos López", "301", LocalDate.of(2026, 9, 25), LocalDate.of(2026, 10, 1), "CONFIRMADA");
        Reserva reserva4 = new Reserva(null, "Ana Martínez", "102", LocalDate.of(2026, 9, 30), LocalDate.of(2026, 10, 3), "PENDIENTE");
        Reserva reserva5 = new Reserva(null, "Roberto Sánchez", "303", LocalDate.of(2026, 10, 5), LocalDate.of(2026, 10, 8), "CONFIRMADA");
        
        reservaRepository.save(reserva1);
        reservaRepository.save(reserva2);
        reservaRepository.save(reserva3);
        reservaRepository.save(reserva4);
        reservaRepository.save(reserva5);
        
        System.out.println("✓ Se han inicializado 5 reservas automáticamente");
    }
}