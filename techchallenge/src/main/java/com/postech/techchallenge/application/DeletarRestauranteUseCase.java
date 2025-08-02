package com.postech.techchallenge.application;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.infrastructure.RestauranteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeletarRestauranteUseCase {

    private RestauranteRepository restauranteRepository;

    public boolean executar(Long id) {
        if (restauranteRepository.existsById(id)) {
            restauranteRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
