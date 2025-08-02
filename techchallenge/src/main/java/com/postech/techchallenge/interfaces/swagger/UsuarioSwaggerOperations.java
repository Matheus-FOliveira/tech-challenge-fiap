package com.postech.techchallenge.interfaces.swagger;

import com.postech.techchallenge.application.request.AtualizarSenhaRequest;
import com.postech.techchallenge.application.request.AtualizarUsuarioRequest;
import com.postech.techchallenge.application.request.CriarUsuarioRequest;
import com.postech.techchallenge.application.response.BuscarSenhaDescriptografadaResponse;
import com.postech.techchallenge.application.response.BuscarTodosUsuariosResponse;
import com.postech.techchallenge.application.response.BuscarUsuarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.postech.techchallenge.domain.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuario", description = "CRUD para gerenciar usuários")
public interface UsuarioSwaggerOperations {

    //POST
    @Operation(summary = "Salvar usuário", description = "Cria um nova usuário")
    public ResponseEntity<Long> criarUsuario(
            @RequestBody CriarUsuarioRequest request);

    //PUT
    @Operation(summary = "Atualizar usuário", description = "Atualiza completamente um usuário existente")
    public ResponseEntity<Usuario> atualizarUsuario(
            @RequestBody AtualizarUsuarioRequest request,
            @PathVariable("id") Long id);

    //PATCH
    @Operation(summary = "Atualizar senha", description = "Atualiza a senha de um usuário existente")
    public ResponseEntity<Usuario> atualizarSenha(
            @RequestBody AtualizarSenhaRequest request,
            @PathVariable("id") Long id);

    //DELETE
    @Operation(summary = "Deletar usuário", description = "Remove um usuário pelo ID")
    public ResponseEntity<Usuario> deletarUsuario(
            @PathVariable("id") Long id);

    //GET
    @Operation(summary = "Buscar usuário", description = "Busca um usuário pelo ID")
    public ResponseEntity<BuscarUsuarioResponse> buscarUsuario(
            @PathVariable("id") Long id);

    //GET
    @Operation(summary = "Buscar todos usuários", description = "Retorna todos usuários do banco")
    public ResponseEntity<BuscarTodosUsuariosResponse> buscarTodosUsuarios();

    //GET
    @Operation(summary = "BuscarSenhaDescriptografada", description = "Retorna a senha descriptografada do usuário")
    public ResponseEntity<BuscarSenhaDescriptografadaResponse> buscarSenhaDescriptografada(
            @PathVariable("id") Long id);

}
