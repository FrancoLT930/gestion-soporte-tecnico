package com.tecnico.soporte.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Esta anotación le dice a Spring que esta clase vigila todos los controladores
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Aquí atrapamos los errores de validación como los @NotBlank del DTO
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> manejarValidaciones(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();

        // Recorremos todos los campos que fallaron y guardamos el nombre del campo y su mensaje
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        // Devolvemos la lista de errores con un código 400 (Bad Request)
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    // Atrapamos el RuntimeException que lanzamos en el Service cuando el ID no existe
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> manejarErroresDeNegocio(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();

        // Tomamos el mensaje que pusimos en el .orElseThrow(...) del Service
        error.put("error_negocio", ex.getMessage());

        // Devolvemos 404 para indicar que el recurso (Cliente o Técnico) no fue encontrado
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}