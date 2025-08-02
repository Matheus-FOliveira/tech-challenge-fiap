package com.postech.techchallenge.application;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.application.response.BuscarRestauranteResponse;
import com.postech.techchallenge.application.response.BuscarTodosRestaurantesResponse;
import com.postech.techchallenge.domain.Restaurante;
import com.postech.techchallenge.infrastructure.RestauranteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscarTodosRestaurantesUseCase {

    private RestauranteRepository restauranteRepository;

    private BuscarTodosRestaurantesResponseMapper mapper;

    public BuscarTodosRestaurantesResponse executar() {
        BuscarTodosRestaurantesResponse response = new BuscarTodosRestaurantesResponse();
        for (Restaurante restaurante : restauranteRepository.findAll()) {
            response.getListaRestaurantes().add(
                    new BuscarRestauranteResponse(
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
