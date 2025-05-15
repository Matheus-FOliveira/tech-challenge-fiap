package com.postech.techchallenge.usecases;

import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BuscarUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public Usuario executar(final Long id) {
        return usuarioRepository.findById(id);
    }
}
