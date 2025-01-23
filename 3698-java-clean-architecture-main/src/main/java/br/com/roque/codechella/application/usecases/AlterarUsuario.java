package br.com.roque.codechella.application.usecases;

import br.com.roque.codechella.application.gateways.RepositorioDeUsuario;
import br.com.roque.codechella.domain.entities.usuario.Usuario;

public class AlterarUsuario {
    private final RepositorioDeUsuario repositorio;

    public AlterarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario alteraDadosUsuario(String cpf, Usuario usuario) {
        return repositorio.alteraUsuario(cpf, usuario);
    }
}
