package com.douglas.cursomc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.douglas.cursomc.domain.Categoria;
import com.douglas.cursomc.repository.CategoriaRepository;
import com.douglas.cursomc.service.CategoriaService;

@Component
public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaRepository categoriaRepository;
	
	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public Optional<Categoria> findById(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return Optional.of(categoria.orElse(null));
	}

	@Override
	public List<Categoria> findAll() {
		List<Categoria> lista = categoriaRepository.findAll();
		return lista;
	}

	@Override
	public Categoria save(Categoria categoria) {
		if(categoria.getId() == null)
			return categoriaRepository.save(categoria);
		return null;
	}

}
