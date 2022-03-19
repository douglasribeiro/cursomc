package com.douglas.cursomc.service;

import java.util.List;
import java.util.Optional;

import com.douglas.cursomc.domain.Categoria;
import com.douglas.cursomc.domain.Cliente;

public interface ClienteService {
	
	List<Cliente> findAll();
	Optional<Cliente> findById(Integer id);
	Cliente save(Cliente cliente);

}
