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
        // Aquí solo pasamos los datos del DTO al Service
        // El Service se encargará de buscar al Cliente y al Técnico por su ID
        Solicitud nueva = solicitudService.guardarDesdeDto(dto);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizar(@PathVariable Integer id, @RequestBody SolicitudDTO dto) {
        // Ahora le pasamos el DTO directo al Service y que él haga la búsqueda
        Solicitud actualizada = solicitudService.actualizar(id, dto);
        return (actualizada != null) ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) { // Cambiado a Integer
        solicitudService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}