package com.postech.techchallenge.application.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class BuscarTodosUsuariosResponse {
    private List<BuscarUsuarioResponse> listaUsuarios = new ArrayList<>();
}
