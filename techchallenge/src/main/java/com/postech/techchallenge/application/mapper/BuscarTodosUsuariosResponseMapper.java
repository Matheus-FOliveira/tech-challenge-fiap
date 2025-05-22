package com.postech.techchallenge.application.mapper;

import com.postech.techchallenge.application.response.BuscarTodosUsuariosResponse;
import com.postech.techchallenge.application.response.BuscarUsuarioResponse;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.shared.EncryptionHelper;

import java.util.List;

public class BuscarTodosUsuariosResponseMapper {

    private static EncryptionHelper encryptionHelper;

    public static BuscarTodosUsuariosResponse mapBuscarTodosUsuariosResponse(final List<Usuario> usuarios) {
        BuscarTodosUsuariosResponse response = new BuscarTodosUsuariosResponse();
        for (Usuario usuario : usuarios) {
            response.getListaUsuarios().add(new BuscarUsuarioResponse(usuario.getId(), usuario.getNome(),
                    usuario.getEndereco(), usuario.getUserLogin(), encryptionHelper.encrypt(usuario.getSenha()),
                    usuario.getEmail()));
        }
        return response;
    }
}
