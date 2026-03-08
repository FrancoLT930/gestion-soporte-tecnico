package com.tecnico.soporte.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok nos ahorra escribir Getters, Setters y Constructores
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitudDTO {

    // Validamos que sí o sí nos manden el número de ID del cliente
    @NotNull(message = "El ID del cliente es obligatorio")
    private Integer clienteId;

    private Integer tecnicoId;

    // No permitimos que la descripción llegue vacía o con puros espacios
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    // Obligamos a que pongan si es prioridad ALTA, MEDIA o BAJA
    @NotBlank(message = "Debe asignar una prioridad")
    private String prioridad;
}