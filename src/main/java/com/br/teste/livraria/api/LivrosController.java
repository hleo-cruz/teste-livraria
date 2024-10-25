package com.br.teste.livraria.api;

import com.br.teste.livraria.api.request.LivroParcialUpdateRequestDTO;
import com.br.teste.livraria.api.request.LivroRequestDTO;
import com.br.teste.livraria.api.response.LivrosResponseDTO;
import com.br.teste.livraria.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("livros")
public class LivrosController {

    @Autowired
    private LivroService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<LivrosResponseDTO> listar() {
        return service.listar();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{livroId}")
    public LivrosResponseDTO buscarPorId(@PathVariable Long livroId) {
        return service.buscarPorId(livroId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void salvar(@Valid @RequestBody LivroRequestDTO livro) {
        service.salvar(livro);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{livroId}")
    public void atualizar(@PathVariable Long livroId, @Valid @RequestBody LivroRequestDTO livro) {
        service.atualizar(livroId, livro);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("{livroId}")
    public void atualizarParcial(@PathVariable Long livroId, @RequestBody LivroParcialUpdateRequestDTO livro) {
        service.atualizarParcial(livroId, livro);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void remover(@PathVariable Long livroId) {
        service.remover(livroId);
    }
}
