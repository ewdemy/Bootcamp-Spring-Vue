package com.mrcruz.cursosbackend.service;

import com.mrcruz.cursosbackend.controller.response.CursoResponse;
import com.mrcruz.cursosbackend.model.Curso;
import com.mrcruz.cursosbackend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public Curso salvar(Curso curso){
        curso.setCriadoEm(LocalDateTime.now());
        return repository.save(curso);
    }

    public List<CursoResponse> listar(){
        List<Curso> cursos = repository.findAll();

        List<CursoResponse> cursosResponse = cursos.stream().map((curso) -> {
            return new CursoResponse(curso);
        }).collect(Collectors.toList());

        return cursosResponse;
    }

    public List<CursoResponse> listarFiltro(Curso filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Curso> example = Example.of(filtro, matcher);

        List<Curso> cursos = repository.findAll(example);

        return cursos.stream().map(CursoResponse::new).collect(Collectors.toList());
    }

    public CursoResponse buscar(Long id){

        return new CursoResponse(repository.findById(id).orElseThrow(EntityNotFoundException::new));
        //Equivale: () -> new EntityNotFoundException(); = EntityNotFoundException::new
    }

    public Curso atualizar(Long id, Curso curso ){
        Optional<Curso> cursoExistente = repository.findById(id);
        if(cursoExistente.isEmpty()){
            throw new EntityNotFoundException();
        }
        curso.setId(id);
        curso.setAtualizadoEm(LocalDateTime.now());
        return repository.save(curso);
    }

    public void deletar(Long id){
    repository.deleteById(id);
    }
}
