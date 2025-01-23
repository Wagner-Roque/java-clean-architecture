package br.com.roque.codechella.infra.controller;

import br.com.roque.codechella.application.usecases.AlterarUsuario;
import br.com.roque.codechella.application.usecases.CadastrarUsuario;
import br.com.roque.codechella.application.usecases.ExcluirUsuario;
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

    private final AlterarUsuario alteraUsuario;

    private final ExcluirUsuario excluiUsuario;

    public UsuarioController(CadastrarUsuario cadastrarUsuario, ListarUsuario listarUsuario, AlterarUsuario alteraUsuario, ExcluirUsuario excluiUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
        this.listarUsuario = listarUsuario;
        this.alteraUsuario = alteraUsuario;
        this.excluiUsuario = excluiUsuario;
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

    @PutMapping("/{cpf}")
    public UsuarioDto atualizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDto dto) {
        Usuario atualizado = alteraUsuario.alteraDadosUsuario(cpf,
                new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UsuarioDto(atualizado.getCpf(), atualizado.getNome(), atualizado.getNascimento(), atualizado.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void excluirUsuario(@PathVariable String cpf) {
        excluiUsuario.excluirUsuario(cpf);
    }
}
