package com.example.sb.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb.entity.Produto;
import com.example.sb.service.ProdutoService;

@RestController
@RequestMapping("/api")
public class ProdutoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("/produtos")
	public List<Produto> listarProdutos(){
		return service.listarProdutos();
	}
	
	@GetMapping("/produtos/{id}")
	public Optional<Produto> acharPorId(@PathVariable Long id){
		return service.acharPorId(id);
	}
	
	@PostMapping("/produtos")
	public Produto adicionarProduto(@RequestBody Produto obj) {
		return service.adicionarProduto(obj);
	}
	
	@DeleteMapping("/produtos/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	@PutMapping("/produtos/{id}")
	public Produto updateProduto(@PathVariable Long id, @RequestBody Produto obj) {
		return obj = service.updateProdutoById(id, obj);
	}
}
