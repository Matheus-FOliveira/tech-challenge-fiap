package com.postech.techchallenge.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postech.techchallenge.domain.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {    
}
