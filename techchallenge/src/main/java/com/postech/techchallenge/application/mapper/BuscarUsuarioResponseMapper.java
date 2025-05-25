package com.postech.techchallenge.application.mapper;

import com.postech.techchallenge.application.response.BuscarUsuarioResponse;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.shared.EncryptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarUsuarioResponseMapper {

    private EncryptionHelper encryptionHelper;

    @Autowired
    public BuscarUsuarioResponseMapper(EncryptionHelper encryptionHelper) {
        this.encryptionHelper = encryptionHelper;
    }

    public BuscarUsuarioResponse mapBuscarUsuarioResponse(Usuario usuario) {
        return new BuscarUsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEndereco(),
                usuario.getUserLogin(), usuario.getSenha(), usuario.getEmail());
    }

}
