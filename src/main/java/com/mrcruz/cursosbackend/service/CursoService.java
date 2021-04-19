package com.mrcruz.cursosbackend.service;

import com.mrcruz.cursosbackend.model.Curso;
import com.mrcruz.cursosbackend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public Curso salvar(Curso curso){
        curso.setCriadoEm(LocalDateTime.now());
        return repository.save(curso);
    }

    public List<Curso> listar(){
        return repository.findAll();
    }

    public Curso buscar(Long id){
    return repository.findById(id).orElseThrow( () -> new EntityNotFoundException());
    }

    public Curso atualizar(Long id, Curso curso ){
        Optional<Curso> cursoExistente = repository.findById(id);
        if(!cursoExistente.isPresent()){
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
