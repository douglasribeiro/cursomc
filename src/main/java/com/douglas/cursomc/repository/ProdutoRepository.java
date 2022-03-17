package com.douglas.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
