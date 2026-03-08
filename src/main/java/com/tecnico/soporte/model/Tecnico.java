package com.tecnico.soporte.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Usamos Lombok para evitar el codigo repetitivo
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tecnico {

    // Identificador único para el técnico
    private Integer id;

    private String nombre;

    // Aquí guardamos en qué es experto: Redes, Software, etc.
    private String especialidad;

    // Un campo extra para saber si está libre para atender una solicitud
    private String disponibilidad;
}