package com.example.app.dto;

import lombok.Data;

@Data
public class TicketDTO {
    private String descripcionProblema;
    private String tipoEquipo;
    private Long clienteId;
}
