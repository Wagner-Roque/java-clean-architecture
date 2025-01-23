package br.com.roque.codechella.infra.controller;

import java.time.LocalDate;

public record UsuarioDto(
        String nome,
        String cpf,
        LocalDate nascimento,
        String email) {
}
