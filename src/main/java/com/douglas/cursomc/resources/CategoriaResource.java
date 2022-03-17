package com.douglas.cursomc.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.cursomc.domain.Categoria;
import com.douglas.cursomc.service.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	private CategoriaService categoriaService;
	
	
	public CategoriaResource(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@GetMapping
	public List<Categoria> listar() {
		return categoriaService.findAll();
	}
	
	@PostMapping
	public Categoria save(@RequestBody Categoria categoria) {
		return categoriaService.save(categoria);
	}

}
