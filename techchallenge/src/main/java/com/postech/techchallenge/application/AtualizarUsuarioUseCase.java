package com.postech.techchallenge.application;

import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AtualizarUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public boolean executar(final Long id, final Usuario novoUsuario) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if (usuarioEncontrado.isPresent()) {
            usuarioEncontrado.get().setNome(novoUsuario.getNome());
            usuarioEncontrado.get().setEmail(novoUsuario.getEmail());
            usuarioEncontrado.get().setUserLogin(novoUsuario.getUserLogin());
            usuarioEncontrado.get().setSenha(novoUsuario.getSenha());
            usuarioEncontrado.get().setEndereco(novoUsuario.getEndereco());
        }
        Optional<Usuario> usuarioSalvo = Optional.of(usuarioRepository.save(usuarioEncontrado.get()));
        return usuarioSalvo.isPresent();
    }

}
