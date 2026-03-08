package com.tecnico.soporte.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok genera automáticamente los Getters, Setters y Constructores
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    // El identificador único que le asigna el repositorio
    private Integer id;
    //Atributos del clietne
    private String nombre;
    private String correo;
    private String telefono;
}