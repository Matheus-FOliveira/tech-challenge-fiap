package com.postech.techchallenge.application.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.postech.techchallenge.application.BuscarTipoUsuarioResponse;
import com.postech.techchallenge.domain.TipoUsuario;

@Component
public class BuscarTodosTiposUsuarioResponseMapper {
    public BuscarTodosTiposUsuarioResponse mapBuscarTodosTiposUsuarioResponse(final List<TipoUsuario> tiposUsuarios) {
        BuscarTodosTiposUsuarioResponse response = new BuscarTodosTiposUsuarioResponse();
        for (TipoUsuario tipoUsuario : tiposUsuarios) {
            response.getListaTiposUsuario().add(new BuscarTipoUsuarioResponse(
                tipoUsuario.getId(), 
                tipoUsuario.getNome(),
                tipoUsuario.getObservacao()));
        }
        return response;
    }
}
