package com.example.app.dto;

import com.example.app.enums.EstadoTicket;
import lombok.Data;

@Data
public class CambioEstadoDTO {
    private EstadoTicket estado;
}
