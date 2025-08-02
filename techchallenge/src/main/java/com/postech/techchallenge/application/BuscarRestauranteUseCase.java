package com.postech.techchallenge.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.application.response.BuscarRestauranteResponse;
import com.postech.techchallenge.domain.Restaurante;
import com.postech.techchallenge.infrastructure.RestauranteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscarRestauranteUseCase {

    private final RestauranteRepository restauranteRepository;

    private BuscarRestauranteResponseMapper mapper;

    public BuscarRestauranteResponse executar(Long id) {
        final Optional<Restaurante> restauranteEncontrado = restauranteRepository.findById(id);
        return restauranteEncontrado.map(mapper::mapBuscarRestauranteResponse).orElse(null);
    }

}
