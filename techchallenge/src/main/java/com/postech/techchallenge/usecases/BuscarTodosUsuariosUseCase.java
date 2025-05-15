package com.postech.techchallenge.usecases;

import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BuscarTodosUsuariosUseCase {

    private UsuarioRepository usuarioRepository;

    public List<Usuario> executar() {
        return usuarioRepository.findAll();
    }

}
