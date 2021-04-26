package com.mrcruz.cursosbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Arquivo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nome;
    private String tipo;

    @Lob
    private byte[] dados;
    private LocalDateTime criadoEm = LocalDateTime.now();
    private LocalDateTime atualizadoEm;

    public Arquivo(String nome, String tipo, byte[] dados){
        this.nome = nome;
        this.tipo = tipo;
        this.dados = dados;
    }
}
