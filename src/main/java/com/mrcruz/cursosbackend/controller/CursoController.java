package com.mrcruz.cursosbackend.controller;

import com.mrcruz.cursosbackend.model.Curso;
import com.mrcruz.cursosbackend.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping
    public List<Curso> listar(){
        return service.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso salvar(@Valid @RequestBody Curso curso){
        return service.salvar(curso);
    }

    @GetMapping("/{id}")
    public Curso buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Curso buscar(@PathVariable Long id, @Valid @RequestBody Curso curso){
        return service.atualizar(id, curso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

}
