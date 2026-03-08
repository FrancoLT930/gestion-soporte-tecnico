package com.tecnico.soporte.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok nos limpia el código de Getters y Setters
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Solicitud {

    // El número de ticket de la solicitud
    private Integer id;

    // Aquí ya no es solo un ID, es el objeto Cliente completo con su nombre, correo, etc.
    private Cliente cliente;

    // Lo mismo para el técnico que atiende el problema
    private Tecnico tecnico;

    //Atributos de la solicitud
    private String descripcion;
    private String prioridad;
    private String estado; // Por ejemplo: "PENDIENTE", "EN PROCESO", "FINALIZADO"
}