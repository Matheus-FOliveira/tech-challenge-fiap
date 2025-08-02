package com.postech.techchallenge.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuscarTipoUsuarioResponse {
    private Long id;
    private String nome;
    private String observacao;
}
