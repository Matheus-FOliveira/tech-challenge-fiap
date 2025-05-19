package com.postech.techchallenge.usecases;

import com.postech.techchallenge.entities.Endereco;
import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.repositories.UsuarioRepository;
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
