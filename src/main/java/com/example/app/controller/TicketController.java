package com.example.app.controller;

import com.example.app.dto.CambioEstadoDTO;
import com.example.app.dto.NotaDiagnosticoDTO;
import com.example.app.dto.TicketDTO;
import com.example.app.model.NotaDiagnostico;
import com.example.app.model.Ticket;
import com.example.app.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<Ticket>> listarTickets() {
        return ResponseEntity.ok(ticketService.obtenerTodos());
    }

    @PostMapping
    public ResponseEntity<Ticket> registrarTicket(@RequestBody TicketDTO ticketDTO) {
        Ticket nuevoTicket = ticketService.crearTicket(ticketDTO);
        return new ResponseEntity<>(nuevoTicket, HttpStatus.CREATED);
    }

    // Endpoint para obtener un ticket y su historial de notas
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> obtenerTicket(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.obtenerPorId(id));
    }

    // Endpoint para agregar una nota a un ticket específico
    @PostMapping("/{id}/notas")
    public ResponseEntity<NotaDiagnostico> agregarNotaATicket(
            @PathVariable Long id,
            @RequestBody NotaDiagnosticoDTO notaDTO) {

        NotaDiagnostico nuevaNota = ticketService.agregarNota(id, notaDTO);
        return new ResponseEntity<>(nuevaNota, HttpStatus.CREATED);
    }

    // Endpoint para actualizar únicamente el estado del ticket
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Ticket> cambiarEstado(
            @PathVariable Long id,
            @RequestBody CambioEstadoDTO estadoDTO) {

        Ticket ticketActualizado = ticketService.cambiarEstado(id, estadoDTO.getEstado());
        return ResponseEntity.ok(ticketActualizado);
    }
}
