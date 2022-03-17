package com.douglas.cursomc.service;

import java.util.List;
import java.util.Optional;

import com.douglas.cursomc.domain.Categoria;

public interface CategoriaService {
	
	List<Categoria> findAll();
	Optional<Categoria> findById(Integer id);
	Categoria save(Categoria categoria);

}
