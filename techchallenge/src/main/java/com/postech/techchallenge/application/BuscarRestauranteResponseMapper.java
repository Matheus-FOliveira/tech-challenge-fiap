package com.postech.techchallenge.application;

import org.springframework.stereotype.Component;

import com.postech.techchallenge.application.response.BuscarRestauranteResponse;
import com.postech.techchallenge.domain.Restaurante;

@Component
public class BuscarRestauranteResponseMapper {

    public BuscarRestauranteResponse mapBuscarRestauranteResponse(Restaurante restaurante) {
        return new BuscarRestauranteResponse(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoCozinha(),
                restaurante.getHorarioFuncionamentoInicial(),
                restaurante.getHorarioFuncionamentoFinal(),
                restaurante.getUsuario().getId()
        );
    }

}
