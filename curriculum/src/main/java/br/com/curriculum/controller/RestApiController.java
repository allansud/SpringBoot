package br.com.curriculum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curriculum.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
}
