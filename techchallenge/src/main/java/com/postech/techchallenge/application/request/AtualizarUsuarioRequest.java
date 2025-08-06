package com.postech.techchallenge.application.request;

import lombok.Getter;

@Getter
public class AtualizarUsuarioRequest {
    private String nome;
    private Long enderecoId;
    private String userLogin;
    private String email;
    private Long tipoUsuarioId;

}
