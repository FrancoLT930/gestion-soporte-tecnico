package com.tecnico.soporte.repository;

import com.tecnico.soporte.model.Solicitud;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SolicitudRepository {
    private final List<Solicitud> solicitudes = new ArrayList<>();
    private Integer idActual = 1;

    public List<Solicitud> findAll() {
        return solicitudes;
    }

    public Optional<Solicitud> findById(Integer id) {
        return solicitudes.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public Solicitud save(Solicitud solicitud) {
        if (solicitud.getId() == null) {
            solicitud.setId(idActual++);
            solicitudes.add(solicitud);
        } else {
            // Lógica para actualizar en la lista
            for (int i = 0; i < solicitudes.size(); i++) {
                if (solicitudes.get(i).getId().equals(solicitud.getId())) {
                    solicitudes.set(i, solicitud);
                    break;
                }
            }
        }
        return solicitud;
    }

    public void deleteById(Integer id) {
        solicitudes.removeIf(s -> s.getId().equals(id));
    }
}