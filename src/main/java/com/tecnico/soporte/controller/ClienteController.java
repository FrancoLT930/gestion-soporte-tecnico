package com.tecnico.soporte.controller;

import com.tecnico.soporte.model.Cliente;
import com.tecnico.soporte.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Esta clase es llama a lo que tenga que ver con Clientes
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    // Traemos las herramientas para guardar y buscar datos de clientes
    @Autowired
    private ClienteRepository clienteRepository;

    // Cuando alguien entra a /api/clientes, le soltamos la lista completa de clientes
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    // Cuando nos mandan datos de un cliente nuevo, lo mandamos a guardar al almacén
    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}