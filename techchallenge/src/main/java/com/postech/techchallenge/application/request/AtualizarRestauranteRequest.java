package com.postech.techchallenge.application.request;

import java.time.LocalTime;

import lombok.Getter;

@Getter
public class AtualizarRestauranteRequest {

    private String nome;
    private Long enderecoId;
    private String tipoCozinha;
    private LocalTime horarioFuncionamentoInicial;
    private LocalTime horarioFuncionamentoFinal;
    private Long usuarioId;
}