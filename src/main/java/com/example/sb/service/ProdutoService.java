package com.example.sb.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb.entity.Produto;
import com.example.sb.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdutoRepository repository;

	public List<Produto> listarProdutos(){
		return repository.findAll();
	}
	
	public Optional<Produto> acharPorId(Long id) {
		return repository.findById(id);
	}
	
	public Produto adicionarProduto(Produto obj) {
		return repository.save(obj);
	}
	
	@Transactional
	public void deleteById(Long id) {
		 repository.deleteById(id);
	}
	
	public Produto updateProdutoById(Long id, Produto obj) {
		Produto entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	public void updateData(Produto entity, Produto obj) {
		entity.setNome(obj.getNome());
		entity.setPreco(obj.getPreco());
		
	}
}
