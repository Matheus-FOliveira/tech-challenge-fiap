package com.postech.techchallenge.application.request;

import java.time.LocalTime;

import com.postech.techchallenge.domain.Endereco;
import com.postech.techchallenge.domain.Usuario;

import lombok.Getter;

@Getter
public class CriarRestauranteRequest {

    private String nome;
    private Endereco endereco;
    private String tipoCozinha;
    private LocalTime horarioFuncionamentoInicial;
    private LocalTime horarioFuncionamentoFinal;
    private Usuario usuario;

}
