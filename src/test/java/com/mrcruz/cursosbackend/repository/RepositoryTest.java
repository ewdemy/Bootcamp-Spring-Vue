package com.mrcruz.cursosbackend.repository;

import com.mrcruz.cursosbackend.model.Curso;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.*;

import java.util.List;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private CursoRepository repository;


    @Test
    void findByNome(){
        List<Curso> cursos = repository.findByNome("Java");
        Assertions.assertThat(cursos).hasSize(1);
    }

    @Test
    void findByNomeLike(){
        List<Curso> cursos = repository.findByNomeLike("%Java%");
        Assertions.assertThat(cursos).hasSizeGreaterThanOrEqualTo(2);
    }

    //Usado para pesquisas quando não se sabe quais campos foram preenchidos
    @Test
    void findByExample(){

        Curso filtro = new Curso();
        filtro.setNome("java");
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(StringMatcher.CONTAINING);

        Example<Curso> example = Example.of(filtro, matcher);

        List<Curso> cursos = repository.findAll(example);
        Assertions.assertThat(cursos).hasSizeGreaterThanOrEqualTo(1);
    }
}
