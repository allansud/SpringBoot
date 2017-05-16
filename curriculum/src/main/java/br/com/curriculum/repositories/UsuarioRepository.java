package br.com.curriculum.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.curriculum.domain.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query(value = "SELECT u FROM Usuario u WHERE u.nome = ?1 AND u.deletado = 0", nativeQuery = true)
	Usuario findByNome(String nome);
	
	@Query(value = "SELECT u FROM Usuario u WHERE u.email = ?1 AND u.deletado = 0", nativeQuery = true)
	Usuario findByEmail(String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.deletado = 0")
	List<Usuario> getUsers();
}
