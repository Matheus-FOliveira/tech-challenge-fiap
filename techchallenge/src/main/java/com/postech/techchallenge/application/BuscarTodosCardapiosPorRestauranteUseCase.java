package com.postech.techchallenge.application;

// import java.util.List;

import org.springframework.stereotype.Service;

// import com.postech.techchallenge.application.mapper.BuscarTodosCardapiosResponseMapper;
// import com.postech.techchallenge.application.response.BuscarTodosCardapiosPorRestauranteResponse;
// import com.postech.techchallenge.application.response.BuscarTodosCardapiosResponse;
// import com.postech.techchallenge.domain.Cardapio;
// import com.postech.techchallenge.infrastructure.CardapioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscarTodosCardapiosPorRestauranteUseCase {

    // private CardapioRepository cardapioRepository;

    // private BuscarTodosCardapiosResponseMapper mapper;

    // public BuscarTodosCardapiosPorRestauranteResponse executar(Long id) {
    //     List<Cardapio> todosCardapios = cardapioRepository.findAll();
    //     BuscarTodosCardapiosPorRestauranteResponse response = new BuscarTodosCardapiosPorRestauranteResponse();
    //     if (!todosCardapios.isEmpty()) {
    //         response.setListaCardapios(mapper.mapBuscarTodosCardapiosResponse(todosCardapios));
    //     }
    //     return response;
    // }
}
