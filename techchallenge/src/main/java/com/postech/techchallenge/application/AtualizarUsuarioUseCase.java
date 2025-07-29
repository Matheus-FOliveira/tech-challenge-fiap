package com.postech.techchallenge.application;

import com.postech.techchallenge.application.request.AtualizarUsuarioRequest;
import com.postech.techchallenge.domain.TipoUsuario;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.TipoUsuarioRepository;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AtualizarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public boolean executar(final Long id, final AtualizarUsuarioRequest request) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if (usuarioEncontrado.isPresent()) {
            TipoUsuario tipo = tipoUsuarioRepository.findById(request.getTipoUsuarioId())
                    .orElseThrow(() -> new IllegalArgumentException("Tipo de usuário inválido"));

            usuarioEncontrado.get().atualizaDados(
                    request.getNome(),
                    request.getEndereco(),
                    request.getUserLogin(),
                    request.getEmail(),
                    tipo
            );

            usuarioRepository.save(usuarioEncontrado.get());
            return true;
        }
        return false;
    }
}
