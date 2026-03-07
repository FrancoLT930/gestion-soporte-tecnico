package com.tecnico.soporte.service;

import com.tecnico.soporte.model.Solicitud;
import com.tecnico.soporte.repository.SolicitudRepository; // Importamos el repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudServiceImpl implements ISolicitudService {

    @Autowired
    private SolicitudRepository repository; // Inyectamos el repositorio

    @Override
    public List<Solicitud> listarTodo() {
        return repository.findAll();
    }

    @Override
    public Solicitud buscarPorId(Integer id) { // Ahora recibe Integer
        return repository.findById(id).orElse(null);
    }

    @Override
    public Solicitud guardar(Solicitud solicitud) {
        solicitud.setEstado("PENDIENTE"); // Lógica de negocio inicial
        return repository.save(solicitud);
    }

    @Override
    public Solicitud actualizar(Integer id, Solicitud nueva) {
        Solicitud existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setCliente(nueva.getCliente());
            existente.setDescripcion(nueva.getDescripcion());
            existente.setPrioridad(nueva.getPrioridad());
            existente.setEstado(nueva.getEstado());
            return repository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) { // Ahora recibe Integer
        repository.deleteById(id);
    }
}