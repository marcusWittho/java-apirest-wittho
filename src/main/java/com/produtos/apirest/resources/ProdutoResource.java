package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.repository.ProdutoRepository;

import com.produtos.apirest.models.Produto;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")	
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")	
	public Produto listaProdutoPorId(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")	
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto/{id}")	
	public void deletaProduto(@PathVariable(value="id") long id) {
		produtoRepository.deleteById(id);
	}
	
	@PutMapping("/produto")	
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
