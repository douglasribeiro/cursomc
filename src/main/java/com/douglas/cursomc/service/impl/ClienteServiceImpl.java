package com.douglas.cursomc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.douglas.cursomc.domain.Cliente;
import com.douglas.cursomc.repository.ClienteRepository;
import com.douglas.cursomc.service.ClienteService;
import com.douglas.cursomc.service.exception.ObjectNotFoundException;

@Component
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public Optional<Cliente> findById(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return Optional.of(cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id)));
	}

	@Override
	public List<Cliente> findAll() {
		List<Cliente> lista = clienteRepository.findAll();
		return lista;
	}

	@Override
	public Cliente save(Cliente cliente) {
		if(cliente.getId() == null)
			return null;
		return clienteRepository.save(cliente);
		
	}

}
