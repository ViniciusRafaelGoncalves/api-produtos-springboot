package com.example.sb.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {

	public String obterMensagem() {
		return "Olá do repositório";
	}
	
	
}
