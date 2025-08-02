package com.postech.techchallenge.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postech.techchallenge.domain.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}