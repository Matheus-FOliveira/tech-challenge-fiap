package com.postech.techchallenge.application;

import org.springframework.stereotype.Service;

import com.postech.techchallenge.infrastructure.TipoUsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeletarTipoUsuarioUseCase {

    private TipoUsuarioRepository tipoUsuarioRepository;

    public boolean execute(Long id) {
        if (tipoUsuarioRepository.existsById(id)) {
            tipoUsuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
