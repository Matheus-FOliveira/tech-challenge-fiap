package com.postech.techchallenge.application.mapper;

import com.postech.techchallenge.application.response.BuscarCardapioResponse;
import com.postech.techchallenge.application.response.BuscarTodosCardapiosResponse;

import com.postech.techchallenge.domain.Cardapio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarTodosCardapiosResponseMapper {

    @Autowired
    public BuscarTodosCardapiosResponseMapper() {
    }

    public BuscarTodosCardapiosResponse mapBuscarTodosCardapiosResponse(final List<Cardapio> cardapios) {
        BuscarTodosCardapiosResponse response = new BuscarTodosCardapiosResponse();
        for (Cardapio cardapio : cardapios) {
            response.getListaCardapios().add(new BuscarCardapioResponse(cardapio.getId(), cardapio.getNome(),
                    cardapio.getDescricao(), cardapio.getPreco(), cardapio.isDisponibilidade(),
                    cardapio.getUrlImagem()));
        }
        return response;
    }
}
