package com.postech.techchallenge.usecases;

import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.repositories.UsuarioRepository;
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
