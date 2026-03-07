package com.tecnico.soporte.service;

import com.tecnico.soporte.model.Solicitud;
import java.util.List;

public interface ISolicitudService {
    List<Solicitud> listarTodo();
    Solicitud buscarPorId(Integer id);
    Solicitud guardar(Solicitud solicitud);
    Solicitud actualizar(Integer id, Solicitud solicitudActualizada);
    void eliminar(Integer id);
}