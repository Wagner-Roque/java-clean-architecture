package br.com.roque.codechella.domain.entities.usuario;

import br.com.roque.codechella.domain.Endereco;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {

    // regras de dominios devem estar aqui nesta classe de dominio e não nas classes
    // de serviços no momento que irá persistir os dados, por exemplo usuário só pode se
    // cdastrar se tiver masi de 18 anos
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario(String nome,String cpf, LocalDate nascimento, String email) {
        if (cpf ==  null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")){
            throw new IllegalArgumentException("Cpf não é válido");
        }

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (email == null || !email.matches(emailRegex)){
            throw new IllegalArgumentException("E-mail inválido");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public Usuario() {

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        if (nascimento == null ){
            throw new IllegalArgumentException("Data de nascimento não pode ser nula");
        }
        LocalDate hoje = LocalDate.now();
        int idade = Period.between(nascimento, hoje).getYears();
        if (idade < 18) {
            throw new IllegalArgumentException("Usuário deve ter pelo menos 18 anos para se cadastrar");
        }
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
         this.email = email;
    }
}
