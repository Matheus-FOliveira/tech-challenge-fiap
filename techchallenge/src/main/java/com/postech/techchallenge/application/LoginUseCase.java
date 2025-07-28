package com.postech.techchallenge.application;

import com.postech.techchallenge.application.request.LoginRequest;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import com.postech.techchallenge.infrastructure.shared.EncryptionHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginUseCase {

    private final UsuarioRepository usuarioRepository;
    private final EncryptionHelper encryptionHelper;

    public Optional<Usuario> executar(LoginRequest request) {
        Optional<Usuario> usuario = usuarioRepository.findByUserLogin(request.getUserLogin());

        if (usuario.isPresent()) {
            String senhaCriptografada = encryptionHelper.encrypt(request.getSenha());
            if (usuario.get().getSenha().equals(senhaCriptografada)) {
                return usuario;
            }
        }

        return Optional.empty();
    }
}
