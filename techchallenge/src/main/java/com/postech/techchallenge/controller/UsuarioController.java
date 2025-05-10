package com.postech.techchallenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Save
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        this.usuarioService.save(usuario);
        return ResponseEntity.status(201).build();
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(
            @RequestBody Usuario usuario,
            @PathVariable("id") Long id) {
        this.usuarioService.update(usuario, id);
        return ResponseEntity.ok().build();
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(
            @PathVariable("id") Long id
        ) {
        this.usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }

}
