package com.postech.techchallenge.application.mapper;

import com.postech.techchallenge.application.response.BuscarCardapioResponse;
import com.postech.techchallenge.domain.Cardapio;
import org.springframework.stereotype.Component;

@Component
public class BuscarCardapioResponseMapper {

    public BuscarCardapioResponse mapBuscarCardapioResponse(Cardapio cardapio) {
        return new BuscarCardapioResponse(cardapio.getId(), cardapio.getNome(), cardapio.getDescricao(),
                cardapio.getPreco(), cardapio.isDisponibilidade(), cardapio.getUrlImagem());
    }

}
