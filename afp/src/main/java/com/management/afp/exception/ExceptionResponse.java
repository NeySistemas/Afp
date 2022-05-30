package com.management.afp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

//La clase sirve para generar una estructra para mostrar el mensaje cuando se genere alguna excepcion
@AllArgsConstructor
@Data
public class ExceptionResponse {
    private LocalDateTime fecha;
    private String mensaje;
    private String detalle;
}
