package com.example.app.model;

import com.example.app.enums.EstadoTicket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcionProblema;

    @Column(nullable = false, length = 100)
    private String tipoEquipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoTicket estado;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaIngreso;

    // Relación Muchos a Uno: Muchos tickets pueden pertenecer a un mismo cliente
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Método que se ejecuta automáticamente antes de insertar el registro en PostgreSQL
    @PrePersist
    protected void onCreate() {
        this.fechaIngreso = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = EstadoTicket.PENDIENTE;
        }
    }
}
