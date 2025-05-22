package com.postech.techchallenge.application.mapper;

import com.postech.techchallenge.application.response.BuscarUsuarioResponse;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.shared.EncryptionHelper;

public class BuscarUsuarioResponseMapper {

    private static EncryptionHelper encryptionHelper;

    public static BuscarUsuarioResponse mapBuscarUsuarioResponse(Usuario usuario) {
        return new BuscarUsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEndereco(),
                usuario.getUserLogin(), encryptionHelper.encrypt(usuario.getSenha()), usuario.getEmail());
    }

}
