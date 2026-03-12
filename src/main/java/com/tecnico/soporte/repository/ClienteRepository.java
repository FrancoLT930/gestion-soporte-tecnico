package com.tecnico.soporte.repository;

import com.tecnico.soporte.model.Cliente;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ClienteRepository {

    // Nuestra lista donde guardamos a los clientes
    private final List<Cliente> clientes = new ArrayList<>();

    // Este es el generador de números. Empieza en 1 y nadie puede usar el mismo número.
    private final AtomicInteger idActual = new AtomicInteger(1);

    // Metodo para ver a todos los clientes
    public List<Cliente> findAll() {
        return clientes;
    }

    // Metodo para guardar un cliente
    public Cliente save(Cliente cliente) {
        // Si el cliente no tiene ID (es nuevo)...
        if (cliente.getId() == null) {
            // Le pedimos un numero nuevo a la máquina (getAndIncrement) y se lo ponemos
            cliente.setId(idActual.getAndIncrement());
            // Lo metemos a la lista
            clientes.add(cliente);
        }
        return cliente;
    }

    // Metodo para buscar a un cliente por su número de ID
    public Optional<Cliente> findById(Integer id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id)) // Filtramos por ID
                .findFirst(); // Devuelve el primero que encuentre
    }
}