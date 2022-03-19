package com.douglas.cursomc.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.cursomc.domain.Cliente;
import com.douglas.cursomc.service.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	private ClienteService clienteService;
	
	
	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping
	public List<Cliente> listar() {
		return clienteService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok().body(clienteService.findById(id).get());
	}
	
	@PostMapping
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

}
