package com.hotel.ejercicio6.repository;

import com.hotel.ejercicio6.model.Reserva;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ReservaRepository {
    private List<Reserva> reservas = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Reserva> findAll() {
        return new ArrayList<>(reservas);
    }

    public Optional<Reserva> findById(Long id) {
        return reservas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    public Reserva save(Reserva reserva) {
        if (reserva.getId() == null) {
            reserva.setId(idCounter++);
        }
        reservas.removeIf(r -> r.getId().equals(reserva.getId()));
        reservas.add(reserva);
        return reserva;
    }
}
