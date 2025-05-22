package com.postech.techchallenge.infrastructure;

import com.postech.techchallenge.domain.Endereco;
import com.postech.techchallenge.infrastructure.shared.EncryptionHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.postech.techchallenge.domain.Usuario;

import java.util.Optional;

@Transactional
@Repository
public class UsuarioCustomRepositoryImp implements UsuarioCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private EncryptionHelper encryptionHelper;

    @Override
    public Optional<Usuario> updateEndereco(final Long id, final Endereco novoEndereco) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario == null) {
            return Optional.empty();
        }

        usuario.setEndereco(novoEndereco);
        final Usuario usuarioAtualizado = entityManager.merge(usuario);

        return Optional.of(usuarioAtualizado);
    }

}
