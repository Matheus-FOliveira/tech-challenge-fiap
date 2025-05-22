package com.postech.techchallenge.application;

import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeletarUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public boolean executar(final Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
