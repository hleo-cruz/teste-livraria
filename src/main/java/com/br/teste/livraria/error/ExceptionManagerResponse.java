package com.br.teste.livraria.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionManagerResponse {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> manageMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(ErrorDTO.builder()
                .message("Existem parâmetro(s) obritório(s) não informado(s).")
                .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity manageNotFoundException(NotFoundException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> manageException(Exception exception) {
        return ResponseEntity.internalServerError().body(ErrorDTO.builder()
                .message("Ocorreu um erro inesperado!")
                .build());
    }
}
