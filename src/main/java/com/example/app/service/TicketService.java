package com.example.app.service;

import com.example.app.dto.TicketDTO;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.model.Cliente;
import com.example.app.model.Ticket;
import com.example.app.repository.ClienteRepository;
import com.example.app.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final ClienteRepository clienteRepository;

    public List<Ticket> obtenerTodos() {
        return ticketRepository.findAll();
    }

    public Ticket crearTicket(TicketDTO ticketDTO) {
        // 1. Verificar que el cliente exista en la base de datos
        Cliente cliente = clienteRepository.findById(ticketDTO.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + ticketDTO.getClienteId()));

        // 2. Mapear el DTO a la Entidad
        Ticket ticket = new Ticket();
        ticket.setDescripcionProblema(ticketDTO.getDescripcionProblema());
        ticket.setTipoEquipo(ticketDTO.getTipoEquipo());
        ticket.setCliente(cliente);

        // La fecha y el estado 'PENDIENTE' se asignan automáticamente por el @PrePersist en la entidad

        // 3. Guardar en la base de datos
        return ticketRepository.save(ticket);
    }
}
