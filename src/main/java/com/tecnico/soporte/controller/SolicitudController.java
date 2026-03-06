package com.tecnico.soporte.controller;

import com.tecnico.soporte.model.Solicitud;
import com.tecnico.soporte.service.ISolicitudService;
import com.tecnico.soporte.dto.SolicitudDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes") // URL pal postmanm
public class SolicitudController {

    @Autowired
    private ISolicitudService solicitudService;

    //LISTAR
    @GetMapping
    public ResponseEntity<List<Solicitud>> listar() {
        return new ResponseEntity<>(solicitudService.listarTodo(), HttpStatus.OK);
    }

    //BUSCAR POR ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> buscar(@PathVariable Long id) {
        Solicitud s = solicitudService.buscarPorId(id);
        return (s != null) ? ResponseEntity.ok(s) : ResponseEntity.notFound().build();
    }

    //CREAR NUEVA SOLICITUD (POST)
    @PostMapping
    public ResponseEntity<Solicitud> crear(@Valid @RequestBody SolicitudDTO dto) {
        // Pasamos los datos del DTO a una nueva Solicitud
        Solicitud nueva = new Solicitud();
        nueva.setCliente(dto.getCliente());
        nueva.setDescripcion(dto.getDescripcion());
        nueva.setPrioridad(dto.getPrioridad());

        Solicitud guardada = solicitudService.guardar(nueva);
        return new ResponseEntity<>(guardada, HttpStatus.CREATED);
    }

    //ACTUALIZAR (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizar(@PathVariable Long id, @RequestBody Solicitud solicitud) {
        Solicitud actualizada = solicitudService.actualizar(id, solicitud);
        return (actualizada != null) ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    //ELIMINAR (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        solicitudService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}