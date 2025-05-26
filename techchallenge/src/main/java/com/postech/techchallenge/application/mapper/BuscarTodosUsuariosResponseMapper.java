package com.postech.techchallenge.application.mapper;

import com.postech.techchallenge.application.response.BuscarTodosUsuariosResponse;
import com.postech.techchallenge.application.response.BuscarUsuarioResponse;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.shared.EncryptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarTodosUsuariosResponseMapper {

    private EncryptionHelper encryptionHelper;

    @Autowired
    public BuscarTodosUsuariosResponseMapper(EncryptionHelper encryptionHelper) {
        this.encryptionHelper = encryptionHelper;
    }

    public BuscarTodosUsuariosResponse mapBuscarTodosUsuariosResponse(final List<Usuario> usuarios) {
        BuscarTodosUsuariosResponse response = new BuscarTodosUsuariosResponse();
        for (Usuario usuario : usuarios) {
            response.getListaUsuarios().add(new BuscarUsuarioResponse(usuario.getId(), usuario.getNome(),
                    usuario.getEndereco(), usuario.getUserLogin(), usuario.getSenha(),
                    usuario.getEmail()));
        }
        return response;
    }
}
