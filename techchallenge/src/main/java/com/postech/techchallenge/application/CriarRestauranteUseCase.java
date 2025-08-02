package com.postech.techchallenge.application;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.application.request.CriarRestauranteRequest;
import com.postech.techchallenge.domain.Restaurante;
import com.postech.techchallenge.infrastructure.RestauranteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CriarRestauranteUseCase {

    private RestauranteRepository restauranteRepository;

    public Long executar(final CriarRestauranteRequest request) {
        Restaurante novoRestaurante = new Restaurante(
                request.getNome(),
                request.getEndereco(),
                request.getTipoCozinha(),
                request.getHorarioFuncionamentoInicial(),
                request.getHorarioFuncionamentoFinal(),
                request.getUsuario());

        Restaurante restauranteSalvo = restauranteRepository.save(novoRestaurante);
        return restauranteSalvo.getId();
    }
}
