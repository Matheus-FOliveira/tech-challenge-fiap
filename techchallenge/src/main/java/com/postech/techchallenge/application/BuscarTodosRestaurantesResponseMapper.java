package com.postech.techchallenge.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.postech.techchallenge.application.response.BuscarRestauranteResponse;
import com.postech.techchallenge.application.response.BuscarTodosRestaurantesResponse;
import com.postech.techchallenge.domain.Restaurante;

@Component
public class BuscarTodosRestaurantesResponseMapper {
    public BuscarTodosRestaurantesResponse mapBuscarTodosRestaurantesResponse(List<Restaurante> restaurantes) {
        BuscarTodosRestaurantesResponse response = new BuscarTodosRestaurantesResponse();
        for (Restaurante restaurante : restaurantes) {
            response.getListaRestaurantes().add(new BuscarRestauranteResponse(
                    restaurante.getId(),
                    restaurante.getNome(),
                    restaurante.getEndereco(),
                    restaurante.getTipoCozinha(),
                    restaurante.getHorarioFuncionamentoInicial(),
                    restaurante.getHorarioFuncionamentoFinal(),
                    restaurante.getUsuario().getId()));
        }
        return response;
    }
}
