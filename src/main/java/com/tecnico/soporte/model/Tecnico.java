package com.tecnico.soporte.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tecnico {
    private Integer id;
    private String nombre;
    private String especialidad; // Ejemplo: Redes, Software, Hardware
    private String disponibilidad; // Ejemplo: Disponible, En Servicio
}