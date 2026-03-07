package com.tecnico.soporte.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera Getters y Setters automáticos
@AllArgsConstructor // Crea un constructor con todos los datos
@NoArgsConstructor  // Crea un constructor vacío
@Builder
public class Solicitud {

    private Integer id;
    private String cliente;
    private String descripcion;
    private String prioridad;
    private String estado;
    private String tecnicoAsignado;
}