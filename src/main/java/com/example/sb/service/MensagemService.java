package com.example.sb.service;

import org.springframework.stereotype.Service;

import com.example.sb.repository.MensagemRepository;

@Service
public class MensagemService {

	public final MensagemRepository mensagemRepository;

	public MensagemService(MensagemRepository mensagemRepository) {
		this.mensagemRepository = mensagemRepository;
	}
	
	public String obterMensagem() {
		return mensagemRepository.obterMensagem();
	}
}
