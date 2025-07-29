package com.postech.techchallenge.application;

import com.postech.techchallenge.application.response.TipoUsuarioResponse;
import com.postech.techchallenge.infrastructure.TipoUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListarTiposUsuarioUseCase {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public List<TipoUsuarioResponse> executar() {
        return tipoUsuarioRepository.findAll().stream()
                .map(tipo -> new TipoUsuarioResponse(tipo.getId(), tipo.getNome()))
                .toList();
    }
}
