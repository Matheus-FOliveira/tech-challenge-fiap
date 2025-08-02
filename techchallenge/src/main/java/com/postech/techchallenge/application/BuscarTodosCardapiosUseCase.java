package com.postech.techchallenge.application;

import com.postech.techchallenge.application.mapper.BuscarTodosCardapiosResponseMapper;
import com.postech.techchallenge.application.response.BuscarTodosCardapiosResponse;
import com.postech.techchallenge.domain.Cardapio;
import com.postech.techchallenge.infrastructure.CardapioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuscarTodosCardapiosUseCase {

    private CardapioRepository cardapioRepository;

    private BuscarTodosCardapiosResponseMapper mapper;

    public BuscarTodosCardapiosResponse executar() {
        List<Cardapio> todosCardapios = cardapioRepository.findAll();
        BuscarTodosCardapiosResponse response = null;
        if (!todosCardapios.isEmpty()) {
            response = mapper.mapBuscarTodosCardapiosResponse(todosCardapios);
        }
        return response;
    }

}
