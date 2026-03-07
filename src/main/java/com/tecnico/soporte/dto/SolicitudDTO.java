package com.tecnico.soporte.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitudDTO {

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String cliente;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 10, message = "La descripción debe tener al menos 10 caracteres")
    private String descripcion;

    @NotBlank(message = "Debe asignar una prioridad")
    private String prioridad;
}