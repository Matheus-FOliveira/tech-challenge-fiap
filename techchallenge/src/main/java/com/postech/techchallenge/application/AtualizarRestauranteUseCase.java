package com.postech.techchallenge.application;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.application.request.AtualizarRestauranteRequest;
import com.postech.techchallenge.domain.Endereco;
import com.postech.techchallenge.domain.Restaurante;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.EnderecoRepository;
import com.postech.techchallenge.infrastructure.RestauranteRepository;
import com.postech.techchallenge.infrastructure.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AtualizarRestauranteUseCase {

    private RestauranteRepository restauranteRepository;
    private UsuarioRepository usuarioRepository;
    private EnderecoRepository enderecoRepository;

    public boolean executar(final Long id, final AtualizarRestauranteRequest request) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElse(null);

        if (restaurante == null) {
            return false;
        }

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Endereco endereco = enderecoRepository.findById(request.getEnderecoId())
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        restaurante.atualizaDados(
                request.getNome(),
                endereco,
                request.getTipoCozinha(),
                request.getHorarioFuncionamentoInicial(),
                request.getHorarioFuncionamentoFinal(),
                usuario
        );

        restauranteRepository.save(restaurante);
        return true;
    }
}
