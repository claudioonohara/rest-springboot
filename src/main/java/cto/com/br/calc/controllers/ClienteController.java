package cto.com.br.calc.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cto.com.br.calc.model.entities.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@GetMapping(path="/clientes/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28,"Pedro","cpf");
	}
	
	@GetMapping("/{id}")
	public Cliente obterClientePorId1(@PathVariable int id) {
		return new Cliente(id, "Maria", "cpf-maria");
	}
	
	@GetMapping
	public Cliente obterClientePorId2(
			@RequestParam(name="id", defaultValue = "1") int id ) {
		return new Cliente(id, "Joao", "joao-maria");
	}
}
