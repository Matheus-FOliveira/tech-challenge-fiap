package com.postech.techchallenge.application.response;

import java.time.LocalTime;

import com.postech.techchallenge.domain.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuscarRestauranteResponse {

    private Long id;
    private String nome;
    private Endereco endereco;
    private String tipoCozinha;
    private LocalTime horarioFuncionamentoInicial;
    private LocalTime horarioFuncionamentoFinal;
    private Long usuarioId;

}
