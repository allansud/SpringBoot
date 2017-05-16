package br.com.curriculum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curriculum.domain.Usuario;
import br.com.curriculum.repositories.UsuarioRepository;

@Service("usuarioService")
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/**
	 * @return Retorna uma lista de usuários não deletados da base de dados.
	 */
	public List<Usuario> getUsers() {
		return usuarioRepository.getUsers();
	}
	
	public Usuario findByName(String nome) {
		return usuarioRepository.findByNome(nome);
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public Usuario findById(long id) {
		return usuarioRepository.findOne(id);
	}
	
	public void updateOrSave(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
