package com.postech.techchallenge.repositories;

import com.postech.techchallenge.entities.Usuario;

public interface UsuarioRepository {
    
    // Criação
    Integer save(Usuario usuario); 

    // Atualização
    Integer update(Usuario usuario, Long id); 

    // Exclusão
    Integer delete(Long id); 

    // Validação
    
}
