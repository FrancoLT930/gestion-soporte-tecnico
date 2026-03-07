package com.tecnico.soporte.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    private Integer id;
    private String nombre;
    private String correo;
    private String telefono;
}