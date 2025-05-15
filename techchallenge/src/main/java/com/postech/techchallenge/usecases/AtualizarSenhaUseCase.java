package com.postech.techchallenge.usecases;

import com.postech.techchallenge.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AtualizarSenhaUseCase {

    private UsuarioRepository usuarioRepository;

    public void executar(final String novaSenha) {
        //TODO
    }

}
