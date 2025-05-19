package com.postech.techchallenge.repositories;

import com.postech.techchallenge.entities.Endereco;
import com.postech.techchallenge.entities.Usuario;

import java.util.Optional;

public interface UsuarioCustomRepository {
    Optional<Usuario> updateEndereco(Long id, Endereco novoEndereco);
    Optional<Usuario> updateSenha(Long id, String novaSenha);
}
