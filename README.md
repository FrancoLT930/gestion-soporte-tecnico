# Sistema de Gestión de Soporte Técnico

##Descripción
Aplicación desarrollada en Java con **Spring Boot 3** para la gestión eficiente de solicitudes de soporte técnico, aplicando arquitectura de capas y persistencia en memoria.

## Arquitectura
- **Controladores:** Gestión de rutas y respuestas HTTP.
- **Servicios:** Lógica de negocio y validaciones.
- **Repositorios:** Gestión de datos en memoria (ArrayList).
- **Modelos/DTOs:** Estructura de datos y transferencia de información.

## Endpoints de la API

### Solicitudes (`/api/solicitudes`)
- `GET /api/solicitudes`: Listar todas las solicitudes.
- `GET /api/solicitudes/{id}`: Buscar solicitud por ID.
- `POST /api/solicitudes`: Crear solicitud (Requiere `clienteId` y `tecnicoId`).
- `PUT /api/solicitudes/{id}`: Actualizar solicitud.
- `DELETE /api/solicitudes/{id}`: Eliminar solicitud.

### Clientes (`/api/clientes`)
- `GET /api/clientes`: Listar clientes.
- `POST /api/clientes`: Registrar nuevo cliente.

### Técnicos (`/api/tecnicos`)
- `GET /api/tecnicos`: Listar técnicos.
- `POST /api/tecnicos`: Registrar nuevo técnico.

## Pruebas con Postman
1. Crear un **Cliente** primero.
2. Crear un **Técnico**.
3. Crear la **Solicitud** enviando los IDs correspondientes.
