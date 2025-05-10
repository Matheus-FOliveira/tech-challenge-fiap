package com.postech.techchallenge.services;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // save
    public void save(Usuario usuario) {

        var save = usuarioRepository.save(usuario);
        Assert.state(save == 1, "Erro ao salvar usuário." + usuario.getNome());
        
    }

    // update
    public void update(Usuario usuario, Long id) {

        var update = usuarioRepository.update(usuario, id);
        Assert.state(update == 1, "Erro ao atualizar usuário." + usuario.getNome());
        
    }

    // delete
    public void delete(Long id) {

        var delete = usuarioRepository.delete(id);
        Assert.state(delete == 1, "Erro ao deletar usuário." + id);
        
    }
    
}
