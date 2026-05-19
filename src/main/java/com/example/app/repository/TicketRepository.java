package com.example.app.repository;

import com.example.app.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Spring Data JPA crea esta consulta automáticamente basándose en el nombre del método
    List<Ticket> findByClienteId(Long clienteId);
}
