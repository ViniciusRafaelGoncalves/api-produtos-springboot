package com.example.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb.service.MensagemService;

@RestController
@RequestMapping("/api")
public class MensagemController {

	public final MensagemService mensagemService;

	public MensagemController(MensagemService mensagemService) {
		this.mensagemService = mensagemService;
	}

	@GetMapping("/mensagem")
	public String obterMensagem() {
		return mensagemService.obterMensagem();
	}

}
