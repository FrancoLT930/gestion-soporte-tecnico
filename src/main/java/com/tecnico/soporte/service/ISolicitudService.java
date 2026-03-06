package com.tecnico.soporte.service;

import com.tecnico.soporte.model.Solicitud;
import java.util.List;

public interface ISolicitudService {
    List<Solicitud> listarTodo();
    Solicitud buscarPorId(Long id);
    Solicitud guardar(Solicitud solicitud);
    Solicitud actualizar(Long id, Solicitud solicitudActualizada);
    void eliminar(Long id);
}