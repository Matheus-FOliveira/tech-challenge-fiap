package com.postech.techchallenge.application;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.application.request.CriarTipoUsuarioRequest;
import com.postech.techchallenge.domain.TipoUsuario;
import com.postech.techchallenge.infrastructure.TipoUsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CriarTipoUsuarioUseCase {

    private TipoUsuarioRepository tipoUsuarioRepository;

    public Long execute(CriarTipoUsuarioRequest request) {
        final TipoUsuario novoTipoUsuario = new TipoUsuario(
            request.getNome(),
            request.getObservacao()
            );
        final TipoUsuario tipoUsuarioCriado = tipoUsuarioRepository.save(novoTipoUsuario);
        
        return tipoUsuarioCriado.getId();
        
    }

}
