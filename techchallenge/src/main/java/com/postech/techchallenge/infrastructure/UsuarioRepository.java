package com.postech.techchallenge.infrastructure;

import com.postech.techchallenge.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioCustomRepository {
}
