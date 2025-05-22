package com.postech.techchallenge.application;

import com.postech.techchallenge.application.dto.CriarUsuarioDTO;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CriarUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public Long executar(final CriarUsuarioDTO dto) {
        final Usuario novoUsuario = new Usuario(dto.getNome(), dto.getEndereco(),
                dto.getSenha(), dto.getUserLogin(), dto.getEmail());
        final Usuario usuarioCriado = usuarioRepository.save(novoUsuario);

        return usuarioCriado.getId();
    }

}
