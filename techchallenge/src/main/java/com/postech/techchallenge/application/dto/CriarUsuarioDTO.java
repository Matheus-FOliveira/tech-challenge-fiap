package com.postech.techchallenge.application.dto;

import com.postech.techchallenge.domain.Endereco;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CriarUsuarioDTO {
    private String nome;
    private String email;
    private String userLogin;
    private String senha;
    private Endereco endereco;
}
