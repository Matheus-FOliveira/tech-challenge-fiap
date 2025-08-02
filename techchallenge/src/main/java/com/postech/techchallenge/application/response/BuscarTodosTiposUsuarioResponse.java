package com.postech.techchallenge.application.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.postech.techchallenge.application.BuscarTipoUsuarioResponse;

@Getter
@NoArgsConstructor
public class BuscarTodosTiposUsuarioResponse {
    private List<BuscarTipoUsuarioResponse> listaTiposUsuario = new ArrayList<>();
}
