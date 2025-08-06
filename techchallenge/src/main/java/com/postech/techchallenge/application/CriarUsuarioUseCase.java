package com.postech.techchallenge.application;

import com.postech.techchallenge.application.request.CriarUsuarioRequest;
import com.postech.techchallenge.domain.Endereco;
import com.postech.techchallenge.domain.TipoUsuario;
import com.postech.techchallenge.domain.Usuario;
import com.postech.techchallenge.infrastructure.EnderecoRepository;
import com.postech.techchallenge.infrastructure.TipoUsuarioRepository;
import com.postech.techchallenge.infrastructure.UsuarioRepository;
import com.postech.techchallenge.infrastructure.shared.EncryptionHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarUsuarioUseCase {

    private final EncryptionHelper encryptionHelper;
    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final EnderecoRepository enderecoRepository;

    public Long executar(final CriarUsuarioRequest request) {
        // 1. Buscar tipo de usuário
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(request.getTipoUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de usuário inválido"));

        // 2. Buscar endereço
        Endereco endereco = enderecoRepository.findById(request.getEnderecoId())
                .orElseThrow(() -> new IllegalArgumentException("Endereço inválido"));

        // 3. Criar o usuário
        Usuario usuario = new Usuario(
                request.getNome(),
                endereco,
                encryptionHelper.encrypt(request.getSenha()),
                request.getUserLogin(),
                request.getEmail(),
                tipoUsuario
        );

        // 4. Salvar e retornar o ID
        return usuarioRepository.save(usuario).getId();
    }
}
