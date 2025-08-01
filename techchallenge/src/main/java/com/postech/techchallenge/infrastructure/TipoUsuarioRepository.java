package com.postech.techchallenge.infrastructure;

import com.postech.techchallenge.domain.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
}
