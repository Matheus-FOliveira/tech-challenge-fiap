package com.postech.techchallenge.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postech.techchallenge.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {}
