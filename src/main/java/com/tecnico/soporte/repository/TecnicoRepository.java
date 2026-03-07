package com.tecnico.soporte.repository;

import com.tecnico.soporte.model.Tecnico;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TecnicoRepository {
    private final List<Tecnico> tecnicos = new ArrayList<>();
    private Integer idActual = 1;

    public List<Tecnico> findAll() {
        return tecnicos;
    }

    public Tecnico save(Tecnico tecnico) {
        if (tecnico.getId() == null) {
            tecnico.setId(idActual++);
            tecnicos.add(tecnico);
        }
        return tecnico;
    }

    public Optional<Tecnico> findById(Integer id) {
        return tecnicos.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }
}