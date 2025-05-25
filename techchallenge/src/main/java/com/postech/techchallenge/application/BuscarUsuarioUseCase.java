package com.postech.techchallenge.application;

import com.postech.techchallenge.application.mapper.BuscarUsuarioResponseMapper;
import com.postech.techchallenge.application.response.BuscarUsuarioResponse;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class BuscarUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    private BuscarUsuarioResponseMapper mapper;

    public BuscarUsuarioResponse executar(final Long id) {
        final Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        return usuarioEncontrado.map(mapper::mapBuscarUsuarioResponse).orElse(null);
    }
}
