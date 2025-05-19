package com.postech.techchallenge.usecases;

import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.repositories.UsuarioRepository;
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
