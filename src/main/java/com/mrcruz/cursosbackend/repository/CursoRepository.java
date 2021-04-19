package com.mrcruz.cursosbackend.repository;

import com.mrcruz.cursosbackend.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByNome(String nome);
    List<Curso> findByNomeLike(String nome);
}
