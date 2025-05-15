package com.postech.techchallenge.usecases;

import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CriarUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public void executar(final Usuario usuario) {
        usuarioRepository.save(usuario);
    }

}
