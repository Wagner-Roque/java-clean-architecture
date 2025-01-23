package br.com.roque.codechella.infra.controller;

import br.com.roque.codechella.application.usecases.CadastrarUsuario;
import br.com.roque.codechella.application.usecases.ListarUsuario;
import br.com.roque.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CadastrarUsuario cadastrarUsuario;
    private final ListarUsuario listarUsuario;

    public UsuarioController(CadastrarUsuario cadastrarUsuario, ListarUsuario listarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
        this.listarUsuario = listarUsuario;
    }

    @PostMapping
    public UsuarioDto cadatraUsuario(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuarioSalvo = cadastrarUsuario.cadastrarUsuario(new Usuario(usuarioDto.cpf(),
                usuarioDto.nome(), usuarioDto.nascimento(), usuarioDto.email()));
        return new UsuarioDto(usuarioSalvo.getCpf(), usuarioSalvo.getNome(), usuarioSalvo.getNascimento(),
                usuarioSalvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios(){
        return listarUsuario.listarTodosUsuarios().stream()
                .map( u-> new UsuarioDto(u.getCpf(), u.getNome(),u.getNascimento(),u.getEmail()))
                .collect(Collectors.toList());
    }
}
