package com.br.teste.livraria;

import com.br.teste.livraria.api.request.LivroRequestDTO;
import com.br.teste.livraria.api.response.LivrosResponseDTO;
import com.br.teste.livraria.service.LivroService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LivroTeste {

    @Autowired
    private LivroService livroService;

    @Test
    public void deveSalvarLivro() {
        // given
        LivroRequestDTO livro = build();

        // when
        livroService.salvar(livro);

        // then
        List<LivrosResponseDTO> listar = livroService.listar();
        assertTrue(listar.stream().filter(livrosResponseDTO -> livrosResponseDTO.getIsbn().equals(livro.getIsbn())).count() > 0);
    }

    @Before
    public void setupListar() {
        LivroRequestDTO livro = build();
        livroService.salvar(livro);
    }

    @Test
    public void deveListar() {
        List<LivrosResponseDTO> listar = livroService.listar();
        assertNotNull(listar);
        assertTrue(listar.size() > 0);
    }

    @Before
    public void setupUpdate() {
        LivroRequestDTO livro = build();
        livroService.salvar(livro);
    }

    @Test
    public void deveAlterarLivro() {

        LivroRequestDTO livroRequestDTO = livroService.listar().stream().map(livro ->
                LivroRequestDTO.builder()
                        .id(livro.getId())
                        .isbn(livro.getIsbn())
                        .titulo("titulo atualizado")
                        .autor(livro.getAutor())
                        .dataLancamento(livro.getDataLancamento())
                        .descricao(livro.getDescricao())
                        .build()
        ).findAny().orElse(null);
        Long id = livroRequestDTO.getId();

        livroService.atualizar(livroRequestDTO.getId(), livroRequestDTO);
        LivrosResponseDTO livrosResponseDTO = livroService.buscarPorId(id);
        assertNotNull(livrosResponseDTO);
        assertTrue(livrosResponseDTO.getTitulo().equals("titulo atualizado"));

    }

    private LivroRequestDTO build() {
        return LivroRequestDTO.builder()
                .isbn("123-456")
                .descricao("descricao-tomate")
                .dataLancamento(LocalDate.now())
                .autor("autor-tomate")
                .titulo("titulo-tomate")
                .build();
    }

    @Before
    public void setupDelete() {
        LivroRequestDTO livro = build();
        livroService.salvar(livro);
    }

    @Test
    public void deveDeletar() {

        livroService.listar().forEach(livro -> {livroService.remover(livro.getId());});
        List<LivrosResponseDTO> listar = livroService.listar();
        assertNotNull(listar);
        assertTrue(listar.size() == 0);
    }
}
