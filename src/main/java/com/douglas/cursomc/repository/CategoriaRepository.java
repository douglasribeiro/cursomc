package com.douglas.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
