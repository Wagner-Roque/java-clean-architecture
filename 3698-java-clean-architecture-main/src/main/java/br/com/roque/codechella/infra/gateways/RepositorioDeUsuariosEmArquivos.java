package br.com.roque.codechella.infra.gateways;

import br.com.roque.codechella.application.gateways.RepositorioDeUsuario;
import br.com.roque.codechella.domain.entities.usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeUsuariosEmArquivos implements RepositorioDeUsuario {
    /**
     * implementando a persistencia em memória sem alterar nada na aplicação
     */
    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }

    @Override
    public Usuario alteraUsuario(String cpf, Usuario usuario) {
        return null;
    }

    @Override
    public void excluiUsuario(String cpf) {

    }

    public void gravarEmArquivos(String nomeArquivo){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(this.usuarios.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
