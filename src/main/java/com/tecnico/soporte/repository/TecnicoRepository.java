package com.tecnico.soporte.repository;

import com.tecnico.soporte.model.Tecnico;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger; // La herramienta para el contador seguro

// repositorio encargado de los técnicos
@Repository
public class TecnicoRepository {

    // guarda a todos los técnicos registrados
    private final List<Tecnico> tecnicos = new ArrayList<>();

    //Contador con atomic para asignar IDs de forma segura entre múltiples usuarios
    private final AtomicInteger idActual = new AtomicInteger(1);

    // Devuelve la lista completa de técnicos
    public List<Tecnico> findAll() {
        return tecnicos;
    }

    // Guarda un técnico: si no tiene ID, le asigna el siguiente número y lo mete a la lista
    public Tecnico save(Tecnico tecnico) {
        if (tecnico.getId() == null) {
            tecnico.setId(idActual.getAndIncrement());
            tecnicos.add(tecnico);
        }
        return tecnico;
    }

    // Busca un técnico específico por su ID usando Streams para filtrar rápido
    public Optional<Tecnico> findById(Integer id) {
        return tecnicos.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }
}