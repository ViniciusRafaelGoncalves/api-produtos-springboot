package com.example.sb.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.sb.entity.Produto;
import com.example.sb.exceptions.DatabaseIntegrityException;
import com.example.sb.exceptions.ResourceNotFoundException;
import com.example.sb.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> listarProdutos() {
		return repository.findAll();
	}

	public Produto acharPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Produto adicionarProduto(Produto obj) {
		return repository.save(obj);
	}

	@Transactional
	public void deleteById(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseIntegrityException("Produto não pôde ser deletado");
		}
	}

	public Produto updateProdutoById(Long id, Produto obj) {
		try {
			Produto entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Produto entity, Produto obj) {
		entity.setNome(obj.getNome());
		entity.setPreco(obj.getPreco());

	}
}
