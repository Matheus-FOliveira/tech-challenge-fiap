package com.postech.techchallenge.application;

import com.postech.techchallenge.application.mapper.BuscarUsuarioResponseMapper;
import com.postech.techchallenge.application.response.BuscarUsuarioResponse;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import com.postech.techchallenge.infrastructure.shared.EncryptionHelper;
import lombok.AllArgsConstructor;

import java.util.Optional;

import static com.postech.techchallenge.application.mapper.BuscarUsuarioResponseMapper.mapBuscarUsuarioResponse;

@AllArgsConstructor
public class BuscarUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public BuscarUsuarioResponse executar(final Long id) {
        final Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        return usuarioEncontrado.map(BuscarUsuarioResponseMapper::mapBuscarUsuarioResponse).orElse(null);
    }
}
