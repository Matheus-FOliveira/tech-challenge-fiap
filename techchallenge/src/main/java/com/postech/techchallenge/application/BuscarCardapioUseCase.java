package com.postech.techchallenge.application;

import com.postech.techchallenge.application.mapper.BuscarCardapioResponseMapper;
import com.postech.techchallenge.application.response.BuscarCardapioResponse;
import com.postech.techchallenge.domain.Cardapio;
import com.postech.techchallenge.infrastructure.CardapioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class BuscarCardapioUseCase {

    private CardapioRepository usuarioRepository;

    private BuscarCardapioResponseMapper mapper;

    public BuscarCardapioResponse executar(final Long id) {
        final Optional<Cardapio> usuarioEncontrado = usuarioRepository.findById(id);
        return usuarioEncontrado.map(mapper::mapBuscarCardapioResponse).orElse(null);
    }
}
