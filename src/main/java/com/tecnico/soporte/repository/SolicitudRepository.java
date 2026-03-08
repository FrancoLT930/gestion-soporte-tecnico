package com.tecnico.soporte.repository;

import com.tecnico.soporte.model.Solicitud;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SolicitudRepository {

    // Nuestra lista principal donde se guardan todos los tickets
    private final List<Solicitud> solicitudes = new ArrayList<>();

    // Contador para que cada ticket tenga un número único (ID)
    private Integer idActual = 1;

    // Devuelve todos los tickets que hemos creado hasta ahora
    public List<Solicitud> findAll() {
        return solicitudes;
    }

    // Busca un ticket específico filtrando por su ID
    public Optional<Solicitud> findById(Integer id) {
        return solicitudes.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    // Metodo para guardar: sirve tanto para CREAR como para ACTUALIZAR
    public Solicitud save(Solicitud solicitud) {
        if (solicitud.getId() == null) {
            // Si no tiene ID, es nuevo: le asignamos uno y lo metemos a la lista
            solicitud.setId(idActual++);
            solicitudes.add(solicitud);
        } else {
            // Si ya tiene ID, es una actualización: buscamos su posición y lo reemplazamos
            for (int i = 0; i < solicitudes.size(); i++) {
                if (solicitudes.get(i).getId().equals(solicitud.getId())) {
                    solicitudes.set(i, solicitud);
                    break;
                }
            }
        }
        return solicitud;
    }

    // Borra el ticket de la lista si el ID coincide
    public void deleteById(Integer id) {
        solicitudes.removeIf(s -> s.getId().equals(id));
    }
}