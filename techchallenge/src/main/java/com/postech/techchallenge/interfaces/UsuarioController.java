package com.postech.techchallenge.interfaces;

import com.postech.techchallenge.application.*;
import com.postech.techchallenge.application.request.AtualizarSenhaRequest;
import com.postech.techchallenge.application.request.AtualizarUsuarioRequest;
import com.postech.techchallenge.application.request.CriarUsuarioRequest;
import com.postech.techchallenge.application.response.BuscarTodosUsuariosResponse;
import com.postech.techchallenge.application.response.BuscarUsuarioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.postech.techchallenge.domain.Usuario;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController implements UsuarioSwaggerOperations {

    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;
    private final AtualizarSenhaUseCase atualizarSenhaUseCase;
    private final DeletarUsuarioUseCase deletarUsuarioUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final BuscarTodosUsuariosUseCase buscarTodosUsuariosUseCase;

    public UsuarioController(CriarUsuarioUseCase criarUsuarioUseCase,
                             AtualizarUsuarioUseCase atualizarUsuarioUseCase,
                             AtualizarSenhaUseCase atualizarSenhaUseCase,
                             DeletarUsuarioUseCase deletarUsuarioUseCase,
                             BuscarUsuarioUseCase buscarUsuarioUseCase,
                             BuscarTodosUsuariosUseCase buscarTodosUsuariosUseCase) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.atualizarUsuarioUseCase = atualizarUsuarioUseCase;
        this.atualizarSenhaUseCase = atualizarSenhaUseCase;
        this.deletarUsuarioUseCase = deletarUsuarioUseCase;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.buscarTodosUsuariosUseCase = buscarTodosUsuariosUseCase;
    }

    @PostMapping
    public ResponseEntity<Long> criarUsuario(@RequestBody final CriarUsuarioRequest request) {
        final Long idNovoUsuario = criarUsuarioUseCase.executar(request);
        if (idNovoUsuario != null) {
            return ResponseEntity.ok(idNovoUsuario);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody final AtualizarUsuarioRequest request,
                                                    @PathVariable final Long id) {
        final boolean usuarioAtualizado = atualizarUsuarioUseCase.executar(id, request);
        if (usuarioAtualizado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PatchMapping("/updateSenha/{id}")
    public ResponseEntity<Usuario> atualizarSenha(@RequestBody final AtualizarSenhaRequest request,
                                                  @PathVariable final Long id) {
        final boolean usuarioAtualizado = atualizarSenhaUseCase.executar(id, request);
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
    public ResponseEntity<BuscarUsuarioResponse> buscarUsuario(@PathVariable final Long id) {
        final BuscarUsuarioResponse response = buscarUsuarioUseCase.executar(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<BuscarTodosUsuariosResponse> buscarTodosUsuarios() {
        final BuscarTodosUsuariosResponse response = buscarTodosUsuariosUseCase.executar();
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

}
