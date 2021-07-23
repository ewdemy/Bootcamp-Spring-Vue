package com.mrcruz.cursosbackend.controller;

import com.mrcruz.cursosbackend.controller.request.CursoRequest;
import com.mrcruz.cursosbackend.controller.response.CursoResponse;
import com.mrcruz.cursosbackend.model.Arquivo;
import com.mrcruz.cursosbackend.model.Curso;
import com.mrcruz.cursosbackend.service.CursoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequestMapping(value = "/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping
    public List<CursoResponse> listar(){
        return service.listar();
    }

    @GetMapping("/filtro")
    public List<CursoResponse> listarFiltro(CursoRequest filtroRequest){
        ModelMapper mapper = new ModelMapper();
        Curso filtro = mapper.map(filtroRequest, Curso.class);
        return service.listarFiltro(filtro);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CursoResponse salvar(@Valid @RequestPart("body") CursoRequest cursoRequest, @RequestPart(value = "file", required = false) MultipartFile arquivoRequest){
        Arquivo arquivo = null;
        System.out.println(arquivoRequest);
        try{
            String nomeArquivo = arquivoRequest.getOriginalFilename();
            String tipo = arquivoRequest.getContentType();
            byte[] conteudo = arquivoRequest.getBytes();

            arquivo = new Arquivo(nomeArquivo, tipo, conteudo);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        ModelMapper mapper = new ModelMapper();
        Curso curso = mapper.map(cursoRequest, Curso.class);

        if(arquivo != null){
            curso.setArquivo(arquivo);
        }
        Curso cursoSalvo = service.salvar(curso);
        return new CursoResponse(cursoSalvo);
    }

    @GetMapping("/{id}")
    public CursoResponse buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CursoResponse buscar(@PathVariable Long id, @Valid @RequestPart("body") CursoRequest cursoRequest, @RequestPart(value = "file", required = false) MultipartFile arquivoRequest){
        Arquivo arquivo = null;
        System.out.println(arquivoRequest);
        try{
            String nomeArquivo = arquivoRequest.getOriginalFilename();
            String tipo = arquivoRequest.getContentType();
            byte[] conteudo = arquivoRequest.getBytes();

            arquivo = new Arquivo(nomeArquivo, tipo, conteudo);
        }catch(Exception ex){
            ex.printStackTrace();
        }


        ModelMapper mapper = new ModelMapper();
        Curso curso = mapper.map(cursoRequest, Curso.class);

        if(arquivo != null){
            curso.setArquivo(arquivo);
        }

        Curso cursoAtualizado = service.atualizar(id, curso);
        return new CursoResponse(cursoAtualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

}
