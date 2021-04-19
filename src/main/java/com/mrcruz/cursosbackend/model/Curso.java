package com.mrcruz.cursosbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "{curso.nome.obrigatorio}" )
    private String nome;

    @Min(value = 1, message = "{curso.preco.minimo}")
    private Double preco;

    @OneToOne
    private Arquivo arquivo;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    @Future(message = "{curso.disponivel.apartir}")
    private LocalDateTime disponivelApartirDe;

}
