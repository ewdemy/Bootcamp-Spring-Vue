package com.mrcruz.cursosbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoRequest {

    private Long id;

    @NotBlank(message = "{curso.nome.obrigatorio}" )
    private String nome;

    @Min(value = 1, message = "{curso.preco.minimo}")
    private Double preco;
}
