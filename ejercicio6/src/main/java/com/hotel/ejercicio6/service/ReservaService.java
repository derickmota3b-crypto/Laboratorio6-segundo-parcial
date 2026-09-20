package com.hotel.ejercicio6.service;

import com.hotel.ejercicio6.model.Reserva;
import com.hotel.ejercicio6.repository.ReservaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva actualizarReserva(Long id, Reserva reservaActualizada) {
        Optional<Reserva> reservaExistente = reservaRepository.findById(id);
        if (reservaExistente.isPresent()) {
            Reserva reserva = reservaExistente.get();
            reserva.setNombreCliente(reservaActualizada.getNombreCliente());
            reserva.setHabitacion(reservaActualizada.getHabitacion());
            reserva.setFechaEntrada(reservaActualizada.getFechaEntrada());
            reserva.setFechaSalida(reservaActualizada.getFechaSalida());
            reserva.setEstado(reservaActualizada.getEstado());
            return reservaRepository.save(reserva);
        }
        return null;
    }

    public Reserva cancelarReserva(Long id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        if (reserva.isPresent()) {
            Reserva r = reserva.get();
            r.setEstado("CANCELADA");
            return reservaRepository.save(r);
        }
        return null;
    }
}

