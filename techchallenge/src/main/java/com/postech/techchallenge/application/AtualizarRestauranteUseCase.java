package com.postech.techchallenge.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.application.request.AtualizarRestauranteRequest;
import com.postech.techchallenge.domain.Restaurante;
import com.postech.techchallenge.infrastructure.RestauranteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AtualizarRestauranteUseCase {

    private RestauranteRepository restauranteRepository;

    public boolean executar(final Long id, final AtualizarRestauranteRequest request) {
        Optional<Restaurante> restauranteEncontrado = restauranteRepository.findById(id);
        if (restauranteEncontrado.isPresent()) {
            restauranteEncontrado.get().atualizaDados(
                request.getNome(),
                request.getEndereco(),
                request.getTipoCozinha(),
                request.getHorarioFuncionamentoInicial(),
                request.getHorarioFuncionamentoFinal(),
                request.getUsuario()
            );

            restauranteRepository.save(restauranteEncontrado.get());
            return true;
        }
        return false;
    }
}
