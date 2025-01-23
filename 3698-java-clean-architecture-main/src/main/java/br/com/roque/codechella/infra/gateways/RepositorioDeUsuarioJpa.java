package br.com.roque.codechella.infra.gateways;

import br.com.roque.codechella.application.gateways.RepositorioDeUsuario;
import br.com.roque.codechella.domain.entities.usuario.Usuario;
import br.com.roque.codechella.infra.persistence.UsuarioEntity;
import br.com.roque.codechella.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repository;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);
        repository.save(usuarioEntity);
        return mapper.toDomain(usuarioEntity);

    }

    @Override
    public List<Usuario> listarTodos() {
            return repository.findAll().stream()
                    .map(mapper::toDomain)
                    .collect(Collectors.toList());
    }

    @Override
    public Usuario alteraUsuario(String cpf, Usuario usuario) {
        UsuarioEntity entity = repository.findByCpf(cpf);
        if (entity != null) {
            var atualizado = mapper.toEntity(usuario);
            atualizado.setId(entity.getId());
            repository.save(atualizado);
            return mapper.toDomain(atualizado);
        }
        return null;
    }

    @Override
    public void excluiUsuario(String cpf) {
        UsuarioEntity entity = repository.findByCpf(cpf);
        repository.deleteById(entity.getId());
    }
}
