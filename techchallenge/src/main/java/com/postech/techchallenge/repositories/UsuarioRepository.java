package com.postech.techchallenge.repositories;

import com.postech.techchallenge.entities.Usuario;

import java.util.List;

public interface UsuarioRepository {
    
    // Criação
    Integer save(Usuario usuario); 

    // Atualização
    Integer update(Usuario usuario, Long id); 

    // Exclusão
    Integer delete(Long id); 

    // Validação
    Usuario findById(Long id);

    List<Usuario> findAll();
}
