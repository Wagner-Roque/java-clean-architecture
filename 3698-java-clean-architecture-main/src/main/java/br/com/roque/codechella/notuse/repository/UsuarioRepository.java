package br.com.roque.codechella.notuse.repository;


import br.com.roque.codechella.notuse.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
