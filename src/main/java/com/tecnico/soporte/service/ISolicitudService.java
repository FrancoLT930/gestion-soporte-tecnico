package com.tecnico.soporte.service;

import com.tecnico.soporte.dto.SolicitudDTO; // Importa el DTO
import com.tecnico.soporte.model.Solicitud;
import java.util.List;

public interface ISolicitudService {
    List<Solicitud> listarTodo();
    Solicitud buscarPorId(Integer id);
    Solicitud guardar(Solicitud solicitud);

    // Este es el nuevo que usamos en el Controller
    Solicitud guardarDesdeDto(SolicitudDTO dto);

    // Cambiamos este para que acepte DTO y no se rompa el Controller
    Solicitud actualizar(Integer id, SolicitudDTO dto);

    void eliminar(Integer id);
}