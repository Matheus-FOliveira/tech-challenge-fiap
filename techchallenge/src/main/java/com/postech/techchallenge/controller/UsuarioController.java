package com.postech.techchallenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/pessoas")
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Save
    @GetMapping 
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        this.usuarioService.save(usuario);
        return ResponseEntity.status(201).build();
    }

    // TODO: Update

    // TODO: Delete


}
