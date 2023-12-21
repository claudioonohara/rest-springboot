package cto.com.br.calc.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cto.com.br.calc.model.entities.Produto;

public interface ProdutoRespository extends PagingAndSortingRepository<Produto, Integer>,CrudRepository<Produto, Integer>{

	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
	//findByNomeContaining
	//findByNomeIsContaining
	//findByNomeContains
	
	// findByNomeStartsWith
	// findByNomeEndsWith
	
	// findByNomeNotContaining
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);
}
