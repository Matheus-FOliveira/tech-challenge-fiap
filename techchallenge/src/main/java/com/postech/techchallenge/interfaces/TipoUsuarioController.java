package com.postech.techchallenge.interfaces;

import com.postech.techchallenge.application.CriarTipoUsuarioUseCase;
import com.postech.techchallenge.application.ListarTiposUsuarioUseCase;
import com.postech.techchallenge.application.request.TipoUsuarioRequest;
import com.postech.techchallenge.application.response.TipoUsuarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipos-usuario")
@RequiredArgsConstructor
public class TipoUsuarioController {

    private final CriarTipoUsuarioUseCase criarTipoUsuarioUseCase;
    private final ListarTiposUsuarioUseCase listarTiposUsuarioUseCase;

    @PostMapping
    public ResponseEntity<Long> criar(@RequestBody TipoUsuarioRequest request) {
        return ResponseEntity.ok(criarTipoUsuarioUseCase.executar(request));
    }

    @GetMapping
    public ResponseEntity<List<TipoUsuarioResponse>> listar() {
        return ResponseEntity.ok(listarTiposUsuarioUseCase.executar());
    }
}
