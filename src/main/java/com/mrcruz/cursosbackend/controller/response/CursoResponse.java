package com.mrcruz.cursosbackend.controller.response;

import com.mrcruz.cursosbackend.model.Curso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoResponse {

    private Long id;
    private String nome;
    private Double preco;

    public CursoResponse(Curso curso){
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.preco = curso.getPreco();
    }
}
