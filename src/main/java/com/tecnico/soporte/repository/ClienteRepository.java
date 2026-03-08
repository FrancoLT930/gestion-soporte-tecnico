package com.tecnico.soporte.repository;

import com.tecnico.soporte.model.Cliente;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Esta anotación le dice a Spring que esta clase maneja los datos
@Repository
public class ClienteRepository {

    // Nuestra "Base de Datos" es simplemente esta lista de Java en memoria
    private final List<Cliente> clientes = new ArrayList<>();

    // Un contador para que cada cliente tenga un ID diferente (1, 2, 3...)
    private Integer idActual = 1;

    // Metodo para devolver todos los clientes que hemos guardado
    public List<Cliente> findAll() {
        return clientes;
    }

    // Metodo para guardar: si el cliente no tiene ID, le asignamos uno y lo metemos a la lista
    public Cliente save(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(idActual++);
            clientes.add(cliente);
        }
        return cliente;
    }

    // Buscamos un cliente por su ID. Usamos Optional por si no lo encontramos (evita errores)
    public Optional<Cliente> findById(Integer id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
}