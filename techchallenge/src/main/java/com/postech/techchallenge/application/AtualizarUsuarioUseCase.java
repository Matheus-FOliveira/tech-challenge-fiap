package com.postech.techchallenge.application;

import com.postech.techchallenge.application.request.AtualizarUsuarioRequest;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AtualizarUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public boolean executar(final Long id, final AtualizarUsuarioRequest request) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if (usuarioEncontrado.isPresent()) {
            usuarioEncontrado.get().atualizaDados(request.getNome(), request.getEndereco(),
                    request.getUserLogin(), request.getEmail());

            usuarioRepository.save(usuarioEncontrado.get());
            return true;
        }
        return false;
    }

}
