package br.com.roque.codechella.domain.entities.usuario;

import br.com.roque.codechella.domain.Endereco;

import java.time.LocalDate;

public class FabricaUsuario {

    private Usuario usuario;

    public Usuario comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento,String email){
        this.usuario = new Usuario(nome, cpf, nascimento, email);
        return this.usuario;
    }

    public Usuario incluiEndereco(String cep, Integer numero, String complemento){
        this.usuario.setEndereco(new Endereco(cep,numero,complemento));
        return this.usuario;
    }
}
