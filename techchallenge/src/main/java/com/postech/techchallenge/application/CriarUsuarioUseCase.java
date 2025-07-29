package com.postech.techchallenge.application;

import com.postech.techchallenge.application.request.CriarUsuarioRequest;
import com.postech.techchallenge.application.request.EnderecoRequest;
import com.postech.techchallenge.domain.Endereco;
import com.postech.techchallenge.domain.TipoUsuario;
import com.postech.techchallenge.domain.Usuario;
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

    public Long executar(final CriarUsuarioRequest request) {
        // 1. Buscar o tipo de usuário
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(request.getTipoUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de usuário inválido"));

        // 2. Converter EnderecoRequest em Endereco
        EnderecoRequest er = request.getEndereco();
        Endereco endereco = new Endereco();
        endereco.setEnderecoLinha1(er.getEnderecoLinha1());
        endereco.setEnderecoLinha2(er.getEnderecoLinha2());
        endereco.setCep(er.getCep());
        endereco.setCidade(er.getCidade());
        endereco.setEstado(er.getEstado());

        // 3. Criar o usuário com todos os dados
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
