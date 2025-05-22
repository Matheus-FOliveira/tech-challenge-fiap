package com.postech.techchallenge.application.response;

import com.postech.techchallenge.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuscarUsuarioResponse {
    private Long id;
    private String nome;
    private Endereco endereco;
    private String userLogin;
    private String senhaEncriptada;
    private String email;

}
