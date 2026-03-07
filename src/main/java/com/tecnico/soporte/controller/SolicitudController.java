package com.tecnico.soporte.controller;

import com.tecnico.soporte.dto.SolicitudDTO;
import com.tecnico.soporte.model.Solicitud;
import com.tecnico.soporte.service.ISolicitudService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    @Autowired
    private ISolicitudService solicitudService;

    @GetMapping
    public ResponseEntity<List<Solicitud>> listar() {
        return ResponseEntity.ok(solicitudService.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> buscar(@PathVariable Integer id) { // Cambiado a Integer
        Solicitud s = solicitudService.buscarPorId(id);
        return (s != null) ? ResponseEntity.ok(s) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Solicitud> crear(@Valid @RequestBody SolicitudDTO dto) {
        // Usamos el Builder para convertir el DTO en Model
        Solicitud nueva = Solicitud.builder()
                .cliente(dto.getCliente())
                .descripcion(dto.getDescripcion())
                .prioridad(dto.getPrioridad())
                .build();

        return new ResponseEntity<>(solicitudService.guardar(nueva), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizar(@PathVariable Integer id, @RequestBody SolicitudDTO dto) {
        Solicitud nueva = Solicitud.builder()
                .cliente(dto.getCliente())
                .descripcion(dto.getDescripcion())
                .prioridad(dto.getPrioridad())
                .estado("ACTUALIZADO") // O lo que necesites
                .build();

        Solicitud actualizada = solicitudService.actualizar(id, nueva);
        return (actualizada != null) ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) { // Cambiado a Integer
        solicitudService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}