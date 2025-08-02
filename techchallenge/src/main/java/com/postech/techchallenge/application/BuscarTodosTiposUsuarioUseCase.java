package com.postech.techchallenge.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.application.response.BuscarTodosTiposUsuarioResponse;
import com.postech.techchallenge.application.response.BuscarTodosTiposUsuarioResponseMapper;
import com.postech.techchallenge.domain.TipoUsuario;
import com.postech.techchallenge.infrastructure.TipoUsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscarTodosTiposUsuarioUseCase {

    private TipoUsuarioRepository tipoUsuarioRepository;

    private BuscarTodosTiposUsuarioResponseMapper mapper;

    public BuscarTodosTiposUsuarioResponse execute() {
        List<TipoUsuario> todosTiposUsuario = tipoUsuarioRepository.findAll();
        BuscarTodosTiposUsuarioResponse response = null;
        if (!todosTiposUsuario.isEmpty()) {
            response = mapper.mapBuscarTodosTiposUsuarioResponse(todosTiposUsuario);
        }
        return response;
    }

}
