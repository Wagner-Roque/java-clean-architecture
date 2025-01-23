package br.com.roque.codechella.config;

import br.com.roque.codechella.application.gateways.RepositorioDeUsuario;
import br.com.roque.codechella.application.usecases.CadastrarUsuario;

import br.com.roque.codechella.application.usecases.ListarUsuario;
import br.com.roque.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.roque.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.roque.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    CadastrarUsuario cadastrarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CadastrarUsuario(repositorioDeUsuario);
    }

    @Bean
    ListarUsuario listarUsuario(RepositorioDeUsuario listDeUsuario){
        return new ListarUsuario(listDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJpa criarRepositorioJPA(UsuarioRepository usuarioRepository, UsuarioEntityMapper mapper) {
        return new RepositorioDeUsuarioJpa(usuarioRepository, mapper);
    }

    @Bean
    UsuarioEntityMapper retornarMapper() {
        return new UsuarioEntityMapper();
    }
}
