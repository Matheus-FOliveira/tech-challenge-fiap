package com.postech.techchallenge.swagger;

import com.postech.techchallenge.entities.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.postech.techchallenge.entities.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Usuario", description = "CRUD para gerenciar usuários")
public interface UsuarioSwaggerOperations {

    //POST
    @Operation(summary = "Salvar usuário", description = "Cria um nova usuário")
    public ResponseEntity<Usuario> criarUsuario(
            @RequestBody Usuario usuário);

    //PUT
    @Operation(summary = "Atualizar usuário", description = "Atualiza completamente um usuário existente")
    public ResponseEntity<Usuario> atualizarUsuario(
            @RequestBody Usuario usuario,
            @PathVariable("id") Long id);

    //PATCH
    @Operation(summary = "Atualizar endereço", description = "Atualiza o endereço de um usuário existente")
    public ResponseEntity<Usuario> atualizarEndereco(
            @RequestBody Endereco novoEndereco,
            @PathVariable("id") Long id);

    //PATCH
    @Operation(summary = "Atualizar senha", description = "Atualiza a senha de um usuário existente")
    public ResponseEntity<Usuario> atualizarSenha(
            @RequestBody String novaSenha,
            @PathVariable("id") Long id);

    //DELETE
    @Operation(summary = "Deletar usuário", description = "Remove um usuário pelo ID")
    public ResponseEntity<Usuario> deletarUsuario(
            @PathVariable("id") Long id);

    //GET
    @Operation(summary = "Buscar usuário", description = "Busca um usuário pelo ID")
    public ResponseEntity<Usuario> buscarUsuario(
            @PathVariable("id") Long id);

    //GET
    @Operation(summary = "Buscar todos usuários", description = "Retorna todos usuários do banco")
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios();

}
