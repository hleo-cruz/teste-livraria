package com.br.teste.livraria.service;

import com.br.teste.livraria.api.request.LivroParcialUpdateRequestDTO;
import com.br.teste.livraria.api.request.LivroRequestDTO;
import com.br.teste.livraria.api.response.LivrosResponseDTO;
import com.br.teste.livraria.error.NotFoundException;
import com.br.teste.livraria.mapper.LivroMapper;
import com.br.teste.livraria.repository.LivroEntity;
import com.br.teste.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroMapper mapper;

    @Autowired
    private LivroRepository repository;

    public List<LivrosResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public LivrosResponseDTO buscarPorId(final Long livroId) {
        final Optional<LivroEntity> livroOptional = repository.findById(livroId);
        return livroOptional.map(mapper::toDto).orElseThrow(NotFoundException::new);
    }


    public void salvar(final LivroRequestDTO livro) {
        repository.save(mapper.toEntity(livro));
    }


    public void atualizar(final Long livroId, final LivroRequestDTO requestDTO) {
        final LivroEntity livro = mapper.toEntityToUpdate(livroId, requestDTO);
        repository.save(livro);
    }

    public void atualizarParcial(final Long livroId, final LivroParcialUpdateRequestDTO requestDTO) {

        final LivroEntity entity = repository.findById(livroId).orElseThrow(NotFoundException::new);
        final LivroEntity livro = mapper.toEntityToParcialUpdate(entity, requestDTO);

        repository.save(livro);
    }


    public void remover(final Long livroId) {
        repository.deleteById(livroId);
    }
}
