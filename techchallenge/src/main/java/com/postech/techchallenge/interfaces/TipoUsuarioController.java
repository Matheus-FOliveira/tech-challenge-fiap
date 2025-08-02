package com.postech.techchallenge.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postech.techchallenge.application.AtualizarTipoUsuarioUseCase;
import com.postech.techchallenge.application.BuscarTipoUsuarioResponse;
import com.postech.techchallenge.application.BuscarTipoUsuarioUseCase;
import com.postech.techchallenge.application.BuscarTodosTiposUsuarioUseCase;
import com.postech.techchallenge.application.CriarTipoUsuarioUseCase;
import com.postech.techchallenge.application.DeletarTipoUsuarioUseCase;
import com.postech.techchallenge.application.request.AtualizarTipoUsuarioRequest;
import com.postech.techchallenge.application.request.CriarTipoUsuarioRequest;
import com.postech.techchallenge.application.response.BuscarTodosTiposUsuarioResponse;
import com.postech.techchallenge.interfaces.swagger.TipoUsuarioSwaggerOperations;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/tipos-usuario")
public class TipoUsuarioController implements TipoUsuarioSwaggerOperations {

    private final BuscarTodosTiposUsuarioUseCase buscarTodosTiposUsuarioUseCase;
    private final BuscarTipoUsuarioUseCase buscarTipoUsuarioUseCase;
    private final CriarTipoUsuarioUseCase criarTipoUsuarioUseCase;
    private final AtualizarTipoUsuarioUseCase atualizarTipoUsuarioUseCase;
    private final DeletarTipoUsuarioUseCase deletarTipoUsuarioUseCase;

    public TipoUsuarioController(
        BuscarTodosTiposUsuarioUseCase buscarTodosTiposUsuarioUseCase,
        BuscarTipoUsuarioUseCase buscarTipoUsuarioUseCase,
        CriarTipoUsuarioUseCase criarTipoUsuarioUseCase,
        AtualizarTipoUsuarioUseCase atualizarTipoUsuarioUseCase,
        DeletarTipoUsuarioUseCase deletarTipoUsuarioUseCase
    ) {
        this.buscarTodosTiposUsuarioUseCase = buscarTodosTiposUsuarioUseCase;
        this.buscarTipoUsuarioUseCase = buscarTipoUsuarioUseCase;
        this.criarTipoUsuarioUseCase = criarTipoUsuarioUseCase;
        this.atualizarTipoUsuarioUseCase = atualizarTipoUsuarioUseCase;
        this.deletarTipoUsuarioUseCase = deletarTipoUsuarioUseCase;
    }

    @GetMapping
    public ResponseEntity<BuscarTodosTiposUsuarioResponse> buscarTodosTiposUsuario() {
        log.info("Buscando todos os tipos de usuário");
        BuscarTodosTiposUsuarioResponse response = buscarTodosTiposUsuarioUseCase.execute();
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscarTipoUsuarioResponse> buscarTipoUsuario(@PathVariable Long id) {
        log.info("Buscando tipo de usuário com ID: {}", id);
        BuscarTipoUsuarioResponse response = buscarTipoUsuarioUseCase.execute(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Long> criarTipoUsuario(@RequestBody CriarTipoUsuarioRequest request) {
        log.info("Criando novo tipo de usuário: {}", request);
        Long id = criarTipoUsuarioUseCase.execute(request);
        if (id != null) {
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarTipoUsuario(@RequestBody AtualizarTipoUsuarioRequest request, @PathVariable Long id) {
        log.info("Atualizando tipo de usuário com ID: {}", id);
        boolean atualizado = atualizarTipoUsuarioUseCase.execute(request, id);
        if (atualizado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoUsuario(@PathVariable Long id) {
        log.info("Deletando tipo de usuário com ID: {}", id);
        boolean deletado = deletarTipoUsuarioUseCase.execute(id);
        if (deletado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
