package com.tecnico.soporte.service;

import com.tecnico.soporte.dto.SolicitudDTO;
import com.tecnico.soporte.model.Solicitud;
import java.util.List;

public interface ISolicitudService {

    //devolver todas las solicitudes registradas
    List<Solicitud> listarTodo();

    //buscar una solicitud específica por su número de ID
    Solicitud buscarPorId(Integer id);

    // Metodo para guardar una solicitud
    Solicitud guardar(Solicitud solicitud);

    //define que el servicio debe saber transformar un DTO en una Solicitud real
    Solicitud guardarDesdeDto(SolicitudDTO dto);

    // Define que para actualizar necesitamos el ID y los nuevos datos que vienen en el DTO
    Solicitud actualizar(Integer id, SolicitudDTO dto);

    // Promesa de borrar una solicitud del sistema usando su ID
    void eliminar(Integer id);
}