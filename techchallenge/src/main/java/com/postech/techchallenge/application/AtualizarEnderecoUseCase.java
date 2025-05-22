package com.postech.techchallenge.application;

import com.postech.techchallenge.domain.Endereco;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AtualizarEnderecoUseCase {

    private UsuarioRepository usuarioRepository;

    public boolean executar(final Long id, final Endereco novoEndereco) {
        final Optional<Usuario> usuarioAtualizado = usuarioRepository.updateEndereco(id, novoEndereco);
        return usuarioAtualizado.isPresent();
    }

}
