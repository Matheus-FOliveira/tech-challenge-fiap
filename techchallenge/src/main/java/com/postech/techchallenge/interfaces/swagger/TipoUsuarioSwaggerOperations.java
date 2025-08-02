package com.postech.techchallenge.interfaces.swagger;

import com.postech.techchallenge.application.request.AtualizarTipoUsuarioRequest;
import com.postech.techchallenge.application.request.CriarTipoUsuarioRequest;
import com.postech.techchallenge.application.response.BuscarTodosTiposUsuarioResponse;
import com.postech.techchallenge.application.BuscarTipoUsuarioResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Tipo de Usuario", description = "CRUD para gerenciar os tipos de usuário")
public interface TipoUsuarioSwaggerOperations {

    // GET
    @Operation(summary = "Buscar todos tipos de usuário", description = "Retorna todos os tipos de usuário")
    public ResponseEntity<BuscarTodosTiposUsuarioResponse> buscarTodosTiposUsuario();

    // GET
    @Operation(summary = "Buscar tipo de usuário", description = "Busca um tipo de usuário pelo ID")
    public ResponseEntity<BuscarTipoUsuarioResponse> buscarTipoUsuario(
            @PathVariable("id") Long id);

    // POST
    @Operation(summary = "Criar tipo de usuário", description = "Cria um novo tipo de usuário")
    public ResponseEntity<Long> criarTipoUsuario(
            @RequestBody CriarTipoUsuarioRequest request);

    // PUT
    @Operation(summary = "Atualizar tipo de usuário", description = "Atualiza completamente um tipo de usuário existente")
    public ResponseEntity<Void> atualizarTipoUsuario(
            @RequestBody AtualizarTipoUsuarioRequest request,
            @PathVariable("id") Long id);

    // DELETE
    @Operation(summary = "Deletar tipo de usuário", description = "Remove um tipo de usuário pelo ID")
    public ResponseEntity<Void> deletarTipoUsuario(
            @PathVariable("id") Long id);
}
