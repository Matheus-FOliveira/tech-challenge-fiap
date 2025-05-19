package com.postech.techchallenge.controller;

import com.postech.techchallenge.entities.Endereco;
import com.postech.techchallenge.usecases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.swagger.UsuarioSwaggerOperations;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController implements UsuarioSwaggerOperations {

    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;
    private final AtualizarEnderecoUseCase atualizarEnderecoUseCase;
    private final AtualizarSenhaUseCase atualizarSenhaUseCase;
    private final DeletarUsuarioUseCase deletarUsuarioUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final BuscarTodosUsuariosUseCase buscarTodosUsuariosUseCase;

    public UsuarioController(CriarUsuarioUseCase criarUsuarioUseCase,
                             AtualizarUsuarioUseCase atualizarUsuarioUseCase,
                             AtualizarEnderecoUseCase atualizarEnderecoUseCase,
                             AtualizarSenhaUseCase atualizarSenhaUseCase,
                             DeletarUsuarioUseCase deletarUsuarioUseCase,
                             BuscarUsuarioUseCase buscarUsuarioUseCase,
                             BuscarTodosUsuariosUseCase buscarTodosUsuariosUseCase) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.atualizarUsuarioUseCase = atualizarUsuarioUseCase;
        this.atualizarEnderecoUseCase = atualizarEnderecoUseCase;
        this.atualizarSenhaUseCase = atualizarSenhaUseCase;
        this.deletarUsuarioUseCase = deletarUsuarioUseCase;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.buscarTodosUsuariosUseCase = buscarTodosUsuariosUseCase;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody final Usuario novoUsuario) {
        final Usuario usuarioCriado = criarUsuarioUseCase.executar(novoUsuario);
        if (usuarioCriado != null) {
            return ResponseEntity.ok(usuarioCriado);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody final Usuario usuario,
                                                    @PathVariable final Long id) {
        final boolean usuarioAtualizado = atualizarUsuarioUseCase.executar(id, usuario);
        if (usuarioAtualizado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PatchMapping("/updateEndereco/{id}")
    public ResponseEntity<Usuario> atualizarEndereco(@RequestBody final Endereco novoEndereco,
                                                     @PathVariable final Long id) {
        final boolean usuarioAtualizado = atualizarEnderecoUseCase.executar(id, novoEndereco);
        if (usuarioAtualizado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PatchMapping("/updateSenha/{id}")
    public ResponseEntity<Usuario> atualizarSenha(@RequestBody final String novaSenha,
                                                  @PathVariable final Long id) {
        final boolean usuarioAtualizado = atualizarSenhaUseCase.executar(id, novaSenha);
        if (usuarioAtualizado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity<Usuario> deletarUsuario(@PathVariable final Long id) {
        final boolean usuarioDeletado = deletarUsuarioUseCase.executar(id);
        if (usuarioDeletado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/buscarUsuario/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable final Long id) {
        final Usuario usuario = buscarUsuarioUseCase.executar(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
        final List<Usuario> todos = buscarTodosUsuariosUseCase.executar();
        if (todos != null && !todos.isEmpty()) {
            return ResponseEntity.ok(todos);
        }
        return ResponseEntity.notFound().build();
    }

}
