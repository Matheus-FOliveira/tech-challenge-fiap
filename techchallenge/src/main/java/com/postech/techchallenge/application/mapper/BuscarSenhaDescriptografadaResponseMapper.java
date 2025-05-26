package com.postech.techchallenge.application.mapper;

import com.postech.techchallenge.application.response.BuscarSenhaDescriptografadaResponse;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.shared.EncryptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarSenhaDescriptografadaResponseMapper {

    private EncryptionHelper encryptionHelper;

    @Autowired
    public BuscarSenhaDescriptografadaResponseMapper(EncryptionHelper encryptionHelper) {
        this.encryptionHelper = encryptionHelper;
    }

    public BuscarSenhaDescriptografadaResponse mapBuscarSenhaDescriptografadaResponse(final Usuario usuario) {
        return new BuscarSenhaDescriptografadaResponse(encryptionHelper.decrypt(usuario.getSenha()));
    }

}
