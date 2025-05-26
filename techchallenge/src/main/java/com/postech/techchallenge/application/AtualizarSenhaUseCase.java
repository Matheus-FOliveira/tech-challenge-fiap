package com.postech.techchallenge.application;

import com.postech.techchallenge.application.request.AtualizarSenhaRequest;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import com.postech.techchallenge.infrastructure.shared.EncryptionHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AtualizarSenhaUseCase {

    private EncryptionHelper encryptionHelper;

    private UsuarioRepository usuarioRepository;

    public boolean executar(final Long id, final AtualizarSenhaRequest request) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if (usuarioEncontrado.isPresent()) {
            usuarioEncontrado.get().atualizaSenha(encryptionHelper.encrypt(request.getNovaSenha()));
            usuarioRepository.save(usuarioEncontrado.get());
            return true;
        }
        return false;
    }

}
