package com.tecnico.soporte.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitudDTO {

    @NotNull(message = "El ID del cliente es obligatorio")
    private Integer clienteId; // Cambiamos String por el ID

    private Integer tecnicoId; // Nuevo: ID del técnico que atenderá

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotBlank(message = "Debe asignar una prioridad")
    private String prioridad;
}