package com.mrcruz.cursosbackend.controller;

import com.mrcruz.cursosbackend.controller.response.CursoResponse;
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
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping
    public List<CursoResponse> listar(){
        return service.listar();
    }

    @GetMapping("/filtro")
    public List<CursoResponse> listarFiltro(Curso filtro){
        return service.listarFiltro(filtro);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoResponse salvar(@Valid @RequestBody Curso curso){
        Curso cursoSalvo = service.salvar(curso);
        return new CursoResponse(cursoSalvo);
    }

    @GetMapping("/{id}")
    public CursoResponse buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public CursoResponse buscar(@PathVariable Long id, @Valid @RequestBody Curso curso){
        Curso cursoAtualizado = service.atualizar(id, curso);
        return new CursoResponse(cursoAtualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

}
