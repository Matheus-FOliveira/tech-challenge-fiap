package com.postech.techchallenge.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.application.request.CriarCardapioRequest;
import com.postech.techchallenge.domain.Cardapio;
import com.postech.techchallenge.infrastructure.CardapioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AtualizarCardapioUseCase {

    private CardapioRepository cardapioRepository;

    public boolean atualizar(final Long id, final CriarCardapioRequest request) {
        Optional<Cardapio> cardapioEncontrado = cardapioRepository.findById(id);
        if (cardapioEncontrado.isPresent()) {
            cardapioEncontrado.get().atualizaDados(request.getNome(), request.getDescricao(),
                    request.getPreco(), request.isDisponibilidade(), request.getUrlImagem());

            cardapioRepository.save(cardapioEncontrado.get());
            return true;
        }
        return false;
    }
    
}
