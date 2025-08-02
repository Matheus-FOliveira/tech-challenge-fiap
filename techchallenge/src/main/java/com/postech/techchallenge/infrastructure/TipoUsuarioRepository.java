package com.postech.techchallenge.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postech.techchallenge.domain.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
}
