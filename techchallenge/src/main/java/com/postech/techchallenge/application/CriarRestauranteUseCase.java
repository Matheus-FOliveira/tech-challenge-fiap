package com.postech.techchallenge.application;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.application.request.CriarRestauranteRequest;
import com.postech.techchallenge.domain.Endereco;
import com.postech.techchallenge.domain.Restaurante;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.EnderecoRepository;
import com.postech.techchallenge.infrastructure.RestauranteRepository;
import com.postech.techchallenge.infrastructure.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CriarRestauranteUseCase {

    private RestauranteRepository restauranteRepository;
    private UsuarioRepository usuarioRepository;
    private EnderecoRepository enderecoRepository;

    public Long executar(final CriarRestauranteRequest request) {

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Endereco endereco = enderecoRepository.findById(request.getEnderecoId())
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        Restaurante novoRestaurante = new Restaurante(
                request.getNome(),
                endereco,
                request.getTipoCozinha(),
                request.getHorarioFuncionamentoInicial(),
                request.getHorarioFuncionamentoFinal(),
                usuario
        );

        Restaurante restauranteSalvo = restauranteRepository.save(novoRestaurante);
        return restauranteSalvo.getId();
    }
}
