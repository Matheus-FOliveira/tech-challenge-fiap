package com.postech.techchallenge.application;

import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AtualizarSenhaUseCase {

    private UsuarioRepository usuarioRepository;

    public boolean executar(final Long id, final String novaSenha) {
        final Optional<Usuario> usuarioAtualizado = usuarioRepository.updateSenha(id, novaSenha);
        return usuarioAtualizado.isPresent();
    }

}
