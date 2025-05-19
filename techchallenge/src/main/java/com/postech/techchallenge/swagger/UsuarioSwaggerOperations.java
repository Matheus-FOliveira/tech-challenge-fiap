package com.postech.techchallenge.swagger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.postech.techchallenge.entities.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuario", description = "CRUD para gerenciar usuários")
public interface UsuarioSwaggerOperations {

    @Operation(summary = "Salvar usuário", description = "Cria uma nova usuário")
    public ResponseEntity<Usuario> save(
            @RequestBody Usuario usuário);

    @Operation(summary = "Atualizar usuário", description = "Atualiza uma usuário existente")
    public ResponseEntity<Usuario> update(
            @RequestBody Usuario usuario,
            @PathVariable("id") Long id);

    @Operation(summary = "Deletar usuário", description = "Remove uma usuário pelo ID")
    public ResponseEntity<Usuario> delete(
            @PathVariable("id") Long id);
}
