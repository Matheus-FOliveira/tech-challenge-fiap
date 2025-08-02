package com.postech.techchallenge.application;

import com.postech.techchallenge.application.request.CriarCardapioRequest;
import com.postech.techchallenge.domain.Cardapio;
import com.postech.techchallenge.infrastructure.CardapioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarCardapioUseCase {

    private CardapioRepository cardapioRepository;

    public Long executar(final CriarCardapioRequest request) {
        final Cardapio novoCardapio = new Cardapio(request.getNome(), request.getDescricao(),
                request.getPreco(), request.isDisponibilidade(), request.getUrlImagem());
        final Cardapio cardapioCriado = cardapioRepository.save(novoCardapio);

        return cardapioCriado.getId();
    }

}
