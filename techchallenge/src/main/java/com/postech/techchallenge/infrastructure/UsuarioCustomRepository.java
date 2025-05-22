package com.postech.techchallenge.infrastructure;

import com.postech.techchallenge.domain.Endereco;
import com.postech.techchallenge.domain.Usuario;

import java.util.Optional;

public interface UsuarioCustomRepository {
    Optional<Usuario> updateEndereco(Long id, Endereco novoEndereco);
    Optional<Usuario> updateSenha(Long id, String novaSenha);
}
