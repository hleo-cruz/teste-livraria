package com.br.teste.livraria.mapper;

import com.br.teste.livraria.api.request.LivroParcialUpdateRequestDTO;
import com.br.teste.livraria.api.request.LivroRequestDTO;
import com.br.teste.livraria.api.response.LivrosResponseDTO;
import com.br.teste.livraria.repository.LivroEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LivroMapper {

    public LivroEntity toEntity(final LivroRequestDTO livro) {

        final String autor = livro.getAutor();
        final String titulo = livro.getTitulo();
        final String isbn = livro.getIsbn();
        final String descricao = livro.getDescricao();
        final LocalDate dataLancamento = livro.getDataLancamento();

        return LivroEntity.builder()
                .autor(autor)
                .titulo(titulo)
                .isbn(isbn)
                .descricao(descricao)
                .dataLancamento(dataLancamento)
                .build();
    }

    public LivroEntity toEntityToUpdate(final Long livroId, final LivroRequestDTO livro) {

        final String autor = livro.getAutor();
        final String titulo = livro.getTitulo();
        final String isbn = livro.getIsbn();
        final String descricao = livro.getDescricao();
        final LocalDate dataLancamento = livro.getDataLancamento();

        return LivroEntity.builder()
                .id(livroId)
                .autor(autor)
                .titulo(titulo)
                .isbn(isbn)
                .descricao(descricao)
                .dataLancamento(dataLancamento)
                .build();

    }

    public LivroEntity toEntityToParcialUpdate(final LivroEntity entity, final LivroParcialUpdateRequestDTO requestDTO) {

        final Long id = entity.getId();
        final String autor = requestDTO.getAutor();
        final String titulo = requestDTO.getTitulo();
        final String isbn = requestDTO.getIsbn();
        final String descricao = requestDTO.getDescricao();
        final LocalDate dataLancamento = requestDTO.getDataLancamento();

        return LivroEntity.builder()
                .id(id)
                .autor(StringUtils.isNotBlank(autor) ? autor : entity.getAutor())
                .titulo(StringUtils.isNotBlank(titulo) ? titulo : entity.getTitulo())
                .isbn(StringUtils.isNotBlank(isbn) ? isbn : entity.getIsbn())
                .descricao(StringUtils.isNotBlank(descricao) ? descricao : entity.getDescricao())
                .dataLancamento(dataLancamento != null ? dataLancamento : entity.getDataLancamento())
                .build();

    }



    public LivrosResponseDTO toDto(LivroEntity livro) {

        final Long id = livro.getId();
        final String autor = livro.getAutor();
        final String titulo = livro.getTitulo();
        final String isbn = livro.getIsbn();
        final String descricao = livro.getDescricao();
        final LocalDate dataLancamento = livro.getDataLancamento();

        return LivrosResponseDTO.builder()
                .id(id)
                .autor(autor)
                .titulo(titulo)
                .isbn(isbn)
                .descricao(descricao)
                .dataLancamento(dataLancamento)
                .build();
    }

}
