package com.postech.techchallenge.repositories;

import com.postech.techchallenge.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioCustomRepository {
}
