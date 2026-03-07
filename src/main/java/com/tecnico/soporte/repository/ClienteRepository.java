package com.tecnico.soporte.repository;

import com.tecnico.soporte.model.Cliente;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();
    private Integer idActual = 1;

    public List<Cliente> findAll() {
        return clientes;
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(idActual++);
            clientes.add(cliente);
        }
        return cliente;
    }

    public Optional<Cliente> findById(Integer id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
}