package com.example.app.controller;

import com.example.app.dto.TicketDTO;
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
}
