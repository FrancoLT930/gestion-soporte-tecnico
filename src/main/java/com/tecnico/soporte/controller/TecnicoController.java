package com.tecnico.soporte.controller;

import com.tecnico.soporte.model.Tecnico;
import com.tecnico.soporte.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Este es el controlador de Técnicos
@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    // Conectamos con el repositorio de técnicos para poder leer y escribir datos
    @Autowired
    private TecnicoRepository tecnicoRepository;

    //GET: Cuando entran a /api/tecnicos por GET, devolvemos la lista de todos los técnicos
    @GetMapping
    public List<Tecnico> listar() {
        return tecnicoRepository.findAll();
    }

    //POST: Aquí recibimos los datos del técnico y los guardamos
    @PostMapping
    public Tecnico crear(@RequestBody Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }
}