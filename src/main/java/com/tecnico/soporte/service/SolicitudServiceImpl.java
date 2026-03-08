package com.tecnico.soporte.service;

import com.tecnico.soporte.dto.SolicitudDTO;
import com.tecnico.soporte.model.Cliente;
import com.tecnico.soporte.model.Solicitud;
import com.tecnico.soporte.model.Tecnico;
import com.tecnico.soporte.repository.ClienteRepository;
import com.tecnico.soporte.repository.SolicitudRepository;
import com.tecnico.soporte.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Esta anotación le dice a Spring que aquí reside toda la lógica de negocio
@Service
public class SolicitudServiceImpl implements ISolicitudService {

    // Necesitamos los 3 repositorios para poder cruzar la información
    @Autowired
    private SolicitudRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Override
    public List<Solicitud> listarTodo() {
        return repository.findAll();
    }

    @Override
    public Solicitud buscarPorId(Integer id) {
        // Buscamos el ticket y si no existe devolvemos un nulo (null)
        return repository.findById(id).orElse(null);
    }

    @Override
    public Solicitud guardar(Solicitud solicitud) {
        return repository.save(solicitud);
    }

    //Convierte el DTO en una Solicitud Real
    @Override
    public Solicitud guardarDesdeDto(SolicitudDTO dto) {

        // 1. Validamos que el cliente exista en el arraylist
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Error: El cliente con ID " + dto.getClienteId() + " no existe."));

        // 2. Buscamos al técnico asignado
        Tecnico tecnico = null;
        if (dto.getTecnicoId() != null) {
            tecnico = tecnicoRepository.findById(dto.getTecnicoId())
                    .orElseThrow(() -> new RuntimeException("Error: El técnico con ID " + dto.getTecnicoId() + " no existe."));
        }

        // 3. Creamos el objeto Solicitud con los objetos completos de Cliente y Técnico
        Solicitud nueva = Solicitud.builder()
                .cliente(cliente)
                .tecnico(tecnico)
                .descripcion(dto.getDescripcion())
                .prioridad(dto.getPrioridad())
                .estado("PENDIENTE") // cada ticket nace como pendiente
                .build();

        // 4. Lo mandamos a guardar al repositorio de solicitudes
        return repository.save(nueva);
    }

    @Override
    public Solicitud actualizar(Integer id, SolicitudDTO dto) {
        // Primero verificamos que el ticket que quieren cambiar realmente exista
        Solicitud existente = repository.findById(id).orElse(null);
        if (existente != null) {
            // Buscamos los nuevos datos del cliente y técnico por sus IDs
            Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElse(null);
            Tecnico tecnico = (dto.getTecnicoId() != null)
                    ? tecnicoRepository.findById(dto.getTecnicoId()).orElse(null)
                    : null;

            // Actualizamos la ficha del ticket con la nueva información
            existente.setCliente(cliente);
            existente.setTecnico(tecnico);
            existente.setDescripcion(dto.getDescripcion());
            existente.setPrioridad(dto.getPrioridad());

            return repository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}