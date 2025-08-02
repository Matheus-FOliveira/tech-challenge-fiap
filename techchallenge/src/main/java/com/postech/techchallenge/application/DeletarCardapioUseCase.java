package com.postech.techchallenge.application;

import com.postech.techchallenge.infrastructure.CardapioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeletarCardapioUseCase {

    private CardapioRepository cardapioRepository;

    public boolean executar(final Long id) {
        if (cardapioRepository.existsById(id)) {
            cardapioRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
