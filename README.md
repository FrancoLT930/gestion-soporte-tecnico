#Sistema de Gestión de Soporte Técnico

Este proyecto es una **API RESTful** desarrollada con **Spring Boot** para gestionar solicitudes de soporte técnico de manera eficiente, eliminando el desorden de los registros en papel o correos.

## Características
- **Arquitectura de Capas:** Separación clara entre controladores, servicios, modelos y DTOs.
- **Validaciones Avanzadas:** Uso de @Valid y anotaciones de Jakarta para asegurar la integridad de los datos.
- **Persistencia en Memoria:** Simulación de base de datos utilizando colecciones de Java (`List`).
- **Manejo Global de Errores:** Respuestas JSON personalizadas para errores de validación.

##Tecnologías utilizadas
* **Java 21**
* **Spring Boot 3.x**
* **Maven** (Gestor de dependencias)
* **Lombok** (Para código limpio)
* **Postman** (Para pruebas funcionales)

## Estructura del Proyecto
```text
src/main/java/com/tecnico/soporte/
├── controller/  # Endpoints de la API
├── service/     # Lógica de negocio e interfaz
├── model/       # Entidad de la Solicitud
├── dto/         # Objetos de transferencia y validación
└── exception/   # Manejo centralizado de excepciones
