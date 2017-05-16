package br.com.curriculum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.curriculum.domain.Usuario;
import br.com.curriculum.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
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
	
	
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<Usuario> getUser(@RequestParam("id") long id) {
		Usuario usuario = usuarioService.findById(id);
		if (usuario == null) {
            logger.error("Usuario com id {} nao encontrado.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updateUser(@PathVariable("id") long id, @RequestBody Usuario usuario) {
		logger.info("Updating Usuario com id {}", id);
		
		Usuario atualUsuario = usuarioService.findById(id);
		
		if (atualUsuario == null) {
            logger.error("Não foi possível atualizar. Usuário com id {} não encontrado.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		atualUsuario.setDeletado(usuario.isDeletado());
		atualUsuario.setEmail(usuario.getEmail());
		atualUsuario.setTelefone(usuario.getTelefone());
		atualUsuario.setUf(usuario.getUf());
		atualUsuario.setNome(usuario.getNome());
		atualUsuario.setSenha(usuario.getSenha());
		
		usuarioService.updateOrSave(atualUsuario);
		return new ResponseEntity<Usuario>(atualUsuario, HttpStatus.OK);
	}
}
