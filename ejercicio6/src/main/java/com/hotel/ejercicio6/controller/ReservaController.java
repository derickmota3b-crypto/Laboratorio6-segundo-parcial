package com.hotel.ejercicio6.controller;

import com.hotel.ejercicio6.model.Reserva;
import com.hotel.ejercicio6.service.ReservaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> obtenerTodasLasReservas() {
        return ResponseEntity.ok(reservaService.obtenerTodasLasReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaService.obtenerReservaPorId(id);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaService.crearReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        Reserva reservaActualizada = reservaService.actualizarReserva(id, reserva);
        if (reservaActualizada != null) return ResponseEntity.ok(reservaActualizada);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Reserva> cancelarReserva(@PathVariable Long id) {
        Reserva reservaCancelada = reservaService.cancelarReserva(id);
        if (reservaCancelada != null) return ResponseEntity.ok(reservaCancelada);
        return ResponseEntity.notFound().build();
    }
}
