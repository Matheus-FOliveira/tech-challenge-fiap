package com.postech.techchallenge.application;

import com.postech.techchallenge.application.mapper.BuscarSenhaDescriptografadaResponseMapper;
import com.postech.techchallenge.application.response.BuscarSenhaDescriptografadaResponse;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BuscarSenhaDescriptografadaUseCase {

    private UsuarioRepository usuarioRepository;

    private BuscarSenhaDescriptografadaResponseMapper mapper;

    public BuscarSenhaDescriptografadaResponse executar(final Long id) {
        final Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        return usuarioEncontrado.map(mapper::mapBuscarSenhaDescriptografadaResponse).orElse(null);

    }
}
