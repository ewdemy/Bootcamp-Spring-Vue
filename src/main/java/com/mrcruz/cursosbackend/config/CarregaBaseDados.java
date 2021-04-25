package com.mrcruz.cursosbackend.config;

import com.mrcruz.cursosbackend.model.Curso;
import com.mrcruz.cursosbackend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Configuration
@Profile("dev")
public class CarregaBaseDados {

    @Autowired
    private CursoRepository repository;

    @Bean
    CommandLineRunner carregaBanco(){
        return args -> {
            Curso curso1 = new Curso();
            Curso curso2 = new Curso();
            Curso curso3 = new Curso();

            curso1.setNome("Java");
            curso1.setPreco(220.45);
            curso1.setCriadoEm(LocalDateTime.now());

            curso2.setNome("JavaScript");
            curso2.setPreco(250.45);

            curso3.setNome("Vue");
            curso3.setPreco(600.00);

            repository.save(curso1);
            repository.save(curso2);
            repository.save(curso3);

        };
    }

}
