package com.postech.techchallenge.application;

import com.postech.techchallenge.application.response.BuscarTodosUsuariosResponse;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.postech.techchallenge.application.mapper.BuscarTodosUsuariosResponseMapper.mapBuscarTodosUsuariosResponse;

@AllArgsConstructor
public class BuscarTodosUsuariosUseCase {

    private UsuarioRepository usuarioRepository;

    public BuscarTodosUsuariosResponse executar() {
        List<Usuario> todosUsuarios = usuarioRepository.findAll();
        BuscarTodosUsuariosResponse response = null;
        if (!todosUsuarios.isEmpty()) {
            response = mapBuscarTodosUsuariosResponse(todosUsuarios);
        }
        return response;
    }

}
