package com.br.teste.livraria.error;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Não foi encontrado registro(s) com o(s) parâmetro(s) informado.");
    }
}
