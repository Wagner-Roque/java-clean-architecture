package br.com.roque.codechella.repository;


import br.com.roque.codechella.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
