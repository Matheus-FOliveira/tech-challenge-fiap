package com.postech.techchallenge.controller;

import com.postech.techchallenge.entities.Endereco;
import com.postech.techchallenge.usecases.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.swagger.UsuarioSwaggerOperations;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController implements UsuarioSwaggerOperations {

    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final AtualizarDadosUseCase atualizarDadosUseCase;
    private final AtualizarEnderecoUseCase atualizarEnderecoUseCase;
    private final AtualizarSenhaUseCase atualizarSenhaUseCase;
    private final DeletarUsuarioUseCase deletarUsuarioUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final BuscarTodosUsuariosUseCase buscarTodosUsuariosUseCase;

    public UsuarioController(CriarUsuarioUseCase criarUsuarioUseCase,
                             AtualizarDadosUseCase atualizarDadosUseCase,
                             AtualizarEnderecoUseCase atualizarEnderecoUseCase,
                             AtualizarSenhaUseCase atualizarSenhaUseCase,
                             DeletarUsuarioUseCase deletarUsuarioUseCase,
                             BuscarUsuarioUseCase buscarUsuarioUseCase,
                             BuscarTodosUsuariosUseCase buscarTodosUsuariosUseCase) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.atualizarDadosUseCase = atualizarDadosUseCase;
        this.atualizarEnderecoUseCase = atualizarEnderecoUseCase;
        this.atualizarSenhaUseCase = atualizarSenhaUseCase;
        this.deletarUsuarioUseCase = deletarUsuarioUseCase;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.buscarTodosUsuariosUseCase = buscarTodosUsuariosUseCase;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(Usuario usuário) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(Usuario usuario, Long id) {
        return null;
    }

    @PatchMapping("/updateEndereco/{id}")
    public ResponseEntity<Usuario> atualizarEndereco(Endereco novoEndereco, Long id) {
        return null;
    }

    @PatchMapping("/updateSenha/{id}")
    public ResponseEntity<Usuario> atualizarSenha(String novaSenha, Long id) {
        return null;
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity<Usuario> deletarUsuario(Long id) {
        //TODO melhorar
        deletarUsuarioUseCase.executar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscarUsuario/{id}")
    public ResponseEntity<Usuario> buscarUsuario(Long id) {
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
