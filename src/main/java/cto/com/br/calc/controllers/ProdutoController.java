package cto.com.br.calc.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cto.com.br.calc.model.entities.Produto;
import cto.com.br.calc.model.repositories.ProdutoRespository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRespository produtoRespository; 
	
	/*
	 * @PostMapping public Produto novoProduto(
	 * 
	 * @RequestParam String nome,
	 * 
	 * @RequestParam double preco,
	 * 
	 * @RequestParam double desconto) { Produto produto = new Produto(nome, preco,
	 * desconto); produtoRespository.save(produto); return produto; }
	 */
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Produto salvarProduto(@Valid Produto produto) {
		produtoRespository.save(produto);
		return produto;
	}
	
	@GetMapping
	public Iterable<Produto> obterProduto() {
		return produtoRespository.findAll();
	}
	
	@GetMapping(path="/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
		//return produtoRespository.findByNomeContainingIgnoreCase(parteNome);
		return produtoRespository.searchByNameLike(parteNome);
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
		Pageable page = PageRequest.of(numeroPagina, qtdePagina);
		return produtoRespository.findAll(page);
	}	
	
	@GetMapping(path="/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRespository.findById(id);
	}
	
	/*
	 * @PutMapping public Produto alterarProduto(Produto produto) {
	 * produtoRespository.save(produto); return produto; }
	 */
	
	@DeleteMapping(path="/{id}")
	public void excluirProduto(@PathVariable int id) {
		produtoRespository.deleteById(id);
	}
}
