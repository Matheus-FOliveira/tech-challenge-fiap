package com.postech.techchallenge.application;

import com.postech.techchallenge.application.request.TipoUsuarioRequest;
import com.postech.techchallenge.domain.TipoUsuario;
import com.postech.techchallenge.infrastructure.TipoUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarTipoUsuarioUseCase {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public Long executar(TipoUsuarioRequest request) {
        TipoUsuario tipo = new TipoUsuario();
        tipo.setNome(request.getNome());
        return tipoUsuarioRepository.save(tipo).getId();
    }
}
