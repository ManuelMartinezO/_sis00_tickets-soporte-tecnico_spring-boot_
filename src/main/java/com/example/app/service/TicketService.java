package com.example.app.service;

import com.example.app.dto.NotaDiagnosticoDTO;
import com.example.app.dto.TicketDTO;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.model.Cliente;
import com.example.app.model.NotaDiagnostico;
import com.example.app.model.Ticket;
import com.example.app.repository.ClienteRepository;
import com.example.app.repository.NotaDiagnosticoRepository;
import com.example.app.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final ClienteRepository clienteRepository;
    private final NotaDiagnosticoRepository notaRepository; // Nuevo

    public List<Ticket> obtenerTodos() {
        return ticketRepository.findAll();
    }

    // Nuevo método para buscar un ticket
    public Ticket obtenerPorId(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado con ID: " + id));
    }

    public Ticket crearTicket(TicketDTO ticketDTO) {
        Cliente cliente = clienteRepository.findById(ticketDTO.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + ticketDTO.getClienteId()));

        Ticket ticket = new Ticket();
        ticket.setDescripcionProblema(ticketDTO.getDescripcionProblema());
        ticket.setTipoEquipo(ticketDTO.getTipoEquipo());
        ticket.setCliente(cliente);

        return ticketRepository.save(ticket);
    }

    // Nuevo método para registrar la nota
    public NotaDiagnostico agregarNota(Long ticketId, NotaDiagnosticoDTO notaDTO) {
        Ticket ticket = obtenerPorId(ticketId); // Reutilizamos el método de arriba

        NotaDiagnostico nota = new NotaDiagnostico();
        nota.setContenido(notaDTO.getContenido());
        nota.setTicket(ticket); // Vinculamos la nota al ticket

        return notaRepository.save(nota);
    }
}
