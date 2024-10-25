package com.br.teste.livraria.api.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LivroParcialUpdateRequestDTO {

    private String titulo;
    private String descricao;
    private String autor;
    private LocalDate dataLancamento;
    private String isbn;
}
