package com.postech.techchallenge.application.request;

import com.postech.techchallenge.domain.Endereco;
import lombok.Getter;

@Getter
public class AtualizarUsuarioRequest {
    private String nome;
    private Endereco endereco;
    private String userLogin;
    private String email;
    private Long tipoUsuarioId;

}
