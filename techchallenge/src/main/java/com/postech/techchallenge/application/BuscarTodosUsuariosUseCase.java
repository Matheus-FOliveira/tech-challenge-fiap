package com.postech.techchallenge.application;

import com.postech.techchallenge.application.mapper.BuscarTodosUsuariosResponseMapper;
import com.postech.techchallenge.application.response.BuscarTodosUsuariosResponse;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class BuscarTodosUsuariosUseCase {

    private UsuarioRepository usuarioRepository;

    private BuscarTodosUsuariosResponseMapper mapper;

    public BuscarTodosUsuariosResponse executar() {
        List<Usuario> todosUsuarios = usuarioRepository.findAll();
        BuscarTodosUsuariosResponse response = null;
        if (!todosUsuarios.isEmpty()) {
            response = mapper.mapBuscarTodosUsuariosResponse(todosUsuarios);
        }
        return response;
    }

}
