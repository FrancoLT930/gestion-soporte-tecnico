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

// Marcamos esta clase como el punto de entrada para los tickets de soporte
@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    // Llamamos al Service, que es el que tiene la lógica
    @Autowired
    private ISolicitudService solicitudService;

    // Ruta para traer todas las solicitudes registradas
    @GetMapping
    public ResponseEntity<List<Solicitud>> listar() {
        return ResponseEntity.ok(solicitudService.listarTodo());
    }

    // GET: Buscamos una solicitud específica usando su ID que viene en la URL
    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> buscar(@PathVariable Integer id) {
        Solicitud s = solicitudService.buscarPorId(id);
        // Si la encuentra manda 200, si no existe manda un 404
        return (s != null) ? ResponseEntity.ok(s) : ResponseEntity.notFound().build();
    }

    // POST: Recibimos los datos (DTO) para crear una solicitud nueva
    @PostMapping
    public ResponseEntity<Solicitud> crear(@Valid @RequestBody SolicitudDTO dto) {
        // Le pasamos el paquete al Service para que él busque al cliente y técnico
        Solicitud nueva = solicitudService.guardarDesdeDto(dto);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    // PUT: Ruta para modificar una solicitud que ya existe
    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizar(@PathVariable Integer id, @RequestBody SolicitudDTO dto) {
        Solicitud actualizada = solicitudService.actualizar(id, dto);
        return (actualizada != null) ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // DELETE: Ruta para borrar una solicitud por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        solicitudService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}