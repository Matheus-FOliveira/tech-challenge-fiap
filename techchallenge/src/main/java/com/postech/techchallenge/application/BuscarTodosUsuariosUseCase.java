package com.postech.techchallenge.application;

import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BuscarTodosUsuariosUseCase {

    private UsuarioRepository usuarioRepository;

    public List<Usuario> executar() {
        return usuarioRepository.findAll();
    }

}
