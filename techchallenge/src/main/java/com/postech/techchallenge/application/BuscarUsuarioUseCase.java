package com.postech.techchallenge.application;

import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class BuscarUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public Usuario executar(final Long id) {
        final Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        return usuarioEncontrado.orElse(null);
    }
}
