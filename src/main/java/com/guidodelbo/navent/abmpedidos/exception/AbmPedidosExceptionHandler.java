package com.guidodelbo.navent.abmpedidos.exception;

import com.guidodelbo.navent.abmpedidos.ui.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class AbmPedidosExceptionHandler {
    @ExceptionHandler(value = {PedidoServiceException.class})
    public ResponseEntity<?> handlePedidoServiceException(PedidoServiceException e, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
