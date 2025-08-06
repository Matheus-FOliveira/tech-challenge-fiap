package com.postech.techchallenge.application;

import com.postech.techchallenge.application.request.AtualizarUsuarioRequest;
import com.postech.techchallenge.domain.Endereco;
import com.postech.techchallenge.domain.TipoUsuario;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.EnderecoRepository;
import com.postech.techchallenge.infrastructure.TipoUsuarioRepository;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final EnderecoRepository enderecoRepository;

    public boolean executar(final Long id, final AtualizarUsuarioRequest request) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) return false;

        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(request.getTipoUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de usuário inválido"));

        Endereco endereco = enderecoRepository.findById(request.getEnderecoId())
                .orElseThrow(() -> new IllegalArgumentException("Endereço inválido"));

        usuario.atualizaDados(
                request.getNome(),
                endereco,
                request.getUserLogin(),
                request.getEmail(),
                tipoUsuario
        );

        usuarioRepository.save(usuario);
        return true;
    }
}
