package com.tecnico.soporte.service;

import com.tecnico.soporte.model.Solicitud;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolicitudServiceImpl implements ISolicitudService {


    private List<Solicitud> solicitudes = new ArrayList<>();
    private Long idGenerado = 1L;

    @Override
    public List<Solicitud> listarTodo() {
        return solicitudes;
    }

    @Override
    public Solicitud buscarPorId(Long id) {
        return solicitudes.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Solicitud guardar(Solicitud solicitud) {
        solicitud.setId(idGenerado++);
        solicitud.setEstado("PENDIENTE");
        solicitudes.add(solicitud);
        return solicitud;
    }

    @Override
    public Solicitud actualizar(Long id, Solicitud nueva) {
        Solicitud existente = buscarPorId(id);
        if (existente != null) {
            existente.setCliente(nueva.getCliente());
            existente.setDescripcion(nueva.getDescripcion());
            existente.setPrioridad(nueva.getPrioridad());
            existente.setEstado(nueva.getEstado());
        }
        return existente;
    }

    @Override
    public void eliminar(Long id) {
        solicitudes.removeIf(s -> s.getId().equals(id));
    }
}