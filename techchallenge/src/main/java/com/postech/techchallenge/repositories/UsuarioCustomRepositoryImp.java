package com.postech.techchallenge.repositories;

import com.postech.techchallenge.entities.Endereco;
import com.postech.techchallenge.helpers.EncryptionHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.postech.techchallenge.entities.Usuario;

import java.util.List;
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

    @Override
    public Optional<Usuario> updateSenha(Long id, String novaSenha) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario == null) {
            return Optional.empty();
        }

        usuario.setSenha(encryptionHelper.encrypt(novaSenha));
        entityManager.merge(usuario);

        return Optional.of(usuario);
    }

}
