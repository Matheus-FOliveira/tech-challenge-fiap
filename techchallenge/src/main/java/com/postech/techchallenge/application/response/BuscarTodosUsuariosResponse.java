package com.postech.techchallenge.application.response;

import lombok.Getter;

import java.util.List;

@Getter
public class BuscarTodosUsuariosResponse {
    private List<BuscarUsuarioResponse> listaUsuarios;
}
