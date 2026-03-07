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

@Service
public class SolicitudServiceImpl implements ISolicitudService {

    @Autowired
    private SolicitudRepository repository;

    @Autowired
    private ClienteRepository clienteRepository; // Inyectamos el de Cliente

    @Autowired
    private TecnicoRepository tecnicoRepository; // Inyectamos el de Tecnico

    @Override
    public List<Solicitud> listarTodo() {
        return repository.findAll();
    }

    @Override
    public Solicitud buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Solicitud guardar(Solicitud solicitud) {
        return repository.save(solicitud);
    }

    @Override
    public Solicitud guardarDesdeDto(SolicitudDTO dto) {
        // 1. Buscamos al cliente
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Error: El cliente con ID " + dto.getClienteId() + " no existe."));

        // 2. Buscamos al técnico (si se envió un ID)
        Tecnico tecnico = null;
        if (dto.getTecnicoId() != null) {
            tecnico = tecnicoRepository.findById(dto.getTecnicoId())
                    .orElseThrow(() -> new RuntimeException("Error: El técnico con ID " + dto.getTecnicoId() + " no existe."));
        }

        // 3. Si ambos existen, creamos la solicitud
        Solicitud nueva = Solicitud.builder()
                .cliente(cliente)
                .tecnico(tecnico)
                .descripcion(dto.getDescripcion())
                .prioridad(dto.getPrioridad())
                .estado("PENDIENTE")
                .build();

        return repository.save(nueva);
    }

    @Override
    public Solicitud actualizar(Integer id, SolicitudDTO dto) {
        Solicitud existente = repository.findById(id).orElse(null);
        if (existente != null) {
            Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElse(null);
            Tecnico tecnico = (dto.getTecnicoId() != null)
                    ? tecnicoRepository.findById(dto.getTecnicoId()).orElse(null)
                    : null;

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