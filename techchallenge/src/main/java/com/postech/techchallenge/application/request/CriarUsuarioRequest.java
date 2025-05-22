package com.postech.techchallenge.application.request;

import com.postech.techchallenge.domain.Endereco;
import lombok.Getter;

@Getter
public class CriarUsuarioRequest {
    private String nome;
    private String email;
    private String userLogin;
    private String senha;
    private Endereco endereco;

}
