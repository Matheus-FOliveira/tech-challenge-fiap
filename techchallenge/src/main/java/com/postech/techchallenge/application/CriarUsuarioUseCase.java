package com.postech.techchallenge.application;

import com.postech.techchallenge.application.request.CriarUsuarioRequest;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import com.postech.techchallenge.infrastructure.shared.EncryptionHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarUsuarioUseCase {

    private EncryptionHelper encryptionHelper;
    private UsuarioRepository usuarioRepository;

    public Long executar(final CriarUsuarioRequest request) {
        final Usuario novoUsuario = new Usuario(request.getNome(), request.getEndereco(),
                request.getSenha(), request.getUserLogin(), request.getEmail());
        novoUsuario.atualizaSenha(encryptionHelper.encrypt(request.getSenha()));
        final Usuario usuarioCriado = usuarioRepository.save(novoUsuario);

        return usuarioCriado.getId();
    }

}
