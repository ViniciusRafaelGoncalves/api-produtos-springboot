package com.example.sb.controller;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.sb.entity.Produto;
import com.example.sb.service.ProdutoService;

@RestController
@RequestMapping("/api")
public class ProdutoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> listarProdutos(){
		List<Produto> list = service.listarProdutos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> acharPorId(@PathVariable Long id){
		Produto obj = service.acharPorId(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto obj) {
		 obj = service.adicionarProduto(obj);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		 return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping("/produtos/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto obj) {
		 obj = service.updateProdutoById(id, obj);
		 return ResponseEntity.ok(obj);
	}
}
