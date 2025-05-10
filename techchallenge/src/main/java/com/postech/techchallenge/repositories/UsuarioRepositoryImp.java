package com.postech.techchallenge.repositories;

import org.springframework.stereotype.Repository;

import com.postech.techchallenge.entities.Usuario;

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

}
