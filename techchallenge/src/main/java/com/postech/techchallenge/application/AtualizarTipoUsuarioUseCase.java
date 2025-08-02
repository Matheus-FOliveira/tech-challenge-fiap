package com.postech.techchallenge.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.application.request.AtualizarTipoUsuarioRequest;
import com.postech.techchallenge.domain.TipoUsuario;
import com.postech.techchallenge.infrastructure.TipoUsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AtualizarTipoUsuarioUseCase {
    private TipoUsuarioRepository tipoUsuarioRepository;

    public boolean execute(AtualizarTipoUsuarioRequest request, Long id) {
        Optional<TipoUsuario> tipoUsuarioEncontrado = tipoUsuarioRepository.findById(id);
        if (tipoUsuarioEncontrado.isPresent()) {
            tipoUsuarioEncontrado.get().atualizaDados(
                    request.getNome(),
                    request.getDescricao());

            tipoUsuarioRepository.save(tipoUsuarioEncontrado.get());
            return true;
        }
        return false;
    }
}
