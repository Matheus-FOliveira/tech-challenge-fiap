package com.postech.techchallenge.repositories;

import org.springframework.stereotype.Repository;

import com.postech.techchallenge.entities.Usuario;

import java.util.List;

@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {

    @Override
    public Integer save(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Integer update(Usuario usuario, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Integer delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Usuario findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById");
    }

    public List<Usuario> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll");
    }

}
