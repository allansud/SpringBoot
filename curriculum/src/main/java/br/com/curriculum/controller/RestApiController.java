package br.com.curriculum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.curriculum.domain.Usuario;
import br.com.curriculum.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listAllUsers() {
		List<Usuario> users = usuarioService.getUsers();
		if (users.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
	}
}
