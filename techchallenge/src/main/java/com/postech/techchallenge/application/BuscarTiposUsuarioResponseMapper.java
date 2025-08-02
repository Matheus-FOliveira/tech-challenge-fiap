package com.postech.techchallenge.application;

import org.springframework.stereotype.Component;

import com.postech.techchallenge.domain.TipoUsuario;

@Component
public class BuscarTiposUsuarioResponseMapper {

    public BuscarTipoUsuarioResponse mapBuscarTipoUsuarioResponse(TipoUsuario tipoUsuario) {
        return new BuscarTipoUsuarioResponse(
                tipoUsuario.getId(),
                tipoUsuario.getNome(),
                tipoUsuario.getObservacao()
        );
    }
}
