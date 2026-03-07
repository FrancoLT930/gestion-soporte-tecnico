package com.tecnico.soporte.controller;

import com.tecnico.soporte.model.Tecnico;
import com.tecnico.soporte.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @GetMapping
    public List<Tecnico> listar() {
        return tecnicoRepository.findAll();
    }

    @PostMapping
    public Tecnico crear(@RequestBody Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }
}