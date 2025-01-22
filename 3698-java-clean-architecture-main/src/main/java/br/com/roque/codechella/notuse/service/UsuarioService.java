package br.com.roque.codechella.notuse.service;



import br.com.roque.codechella.notuse.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}
