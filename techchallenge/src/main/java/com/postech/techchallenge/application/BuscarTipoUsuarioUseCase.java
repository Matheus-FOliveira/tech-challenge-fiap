package com.postech.techchallenge.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.domain.TipoUsuario;
import com.postech.techchallenge.infrastructure.TipoUsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscarTipoUsuarioUseCase {

    private TipoUsuarioRepository tipoUsuarioRepository;

    private BuscarTiposUsuarioResponseMapper mapper;

    public BuscarTipoUsuarioResponse execute(Long id) {
        final Optional<TipoUsuario> tipoUsuarioEncontrado = tipoUsuarioRepository.findById(id);
        return tipoUsuarioEncontrado.map(mapper::mapBuscarTipoUsuarioResponse).orElse(null);
    }

}
