package com.postech.techchallenge.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postech.techchallenge.application.AtualizarCardapioUseCase;
import com.postech.techchallenge.application.BuscarCardapioUseCase;
import com.postech.techchallenge.application.BuscarTodosCardapiosUseCase;
import com.postech.techchallenge.application.CriarCardapioUseCase;
import com.postech.techchallenge.application.DeletarCardapioUseCase;
import com.postech.techchallenge.application.request.CriarCardapioRequest;
import com.postech.techchallenge.application.response.BuscarTodosCardapiosResponse;
import com.postech.techchallenge.application.response.BuscarCardapioResponse;
import com.postech.techchallenge.interfaces.swagger.CardapioSwaggerOperations;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/cardapios")
public class CardapioController implements CardapioSwaggerOperations {

    private final CriarCardapioUseCase criarCardapioUseCase;
    private final AtualizarCardapioUseCase atualizarCardapioUseCase;
    private final DeletarCardapioUseCase deletarCardapioUseCase;
    private final BuscarTodosCardapiosUseCase buscarTodosCardapiosUseCase;
    private final BuscarCardapioUseCase buscarCardapioUseCase;

    public CardapioController(CriarCardapioUseCase criarCardapioUseCase,
            AtualizarCardapioUseCase atualizarCardapioUseCase,
            DeletarCardapioUseCase deletarCardapioUseCase,
            BuscarTodosCardapiosUseCase buscarTodosCardapiosUseCase,
            BuscarCardapioUseCase buscarCardapioUseCase) {
        this.criarCardapioUseCase = criarCardapioUseCase;
        this.atualizarCardapioUseCase = atualizarCardapioUseCase;
        this.deletarCardapioUseCase = deletarCardapioUseCase;
        this.buscarTodosCardapiosUseCase = buscarTodosCardapiosUseCase;
        this.buscarCardapioUseCase = buscarCardapioUseCase;
    }

    @GetMapping
    public ResponseEntity<BuscarTodosCardapiosResponse> buscarTodosCardapios() {
        log.info("Iniciando busca de todos os cardápios");
        final BuscarTodosCardapiosResponse response = buscarTodosCardapiosUseCase.executar();
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscarCardapioResponse> buscarCardapio(@PathVariable final Long id) {
        log.info("Iniciando busca de um cardápio");
        final BuscarCardapioResponse response = buscarCardapioUseCase.executar(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Long> criarCardapio(@RequestBody final CriarCardapioRequest request) {
        log.info("Iniciando criação de cardápio");
        final Long idNovoCardapio = criarCardapioUseCase.executar(request);
        if (idNovoCardapio != null) {
            return ResponseEntity.ok(idNovoCardapio);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCardapio(@RequestBody final CriarCardapioRequest request,
            @PathVariable final Long id) {
        log.info("Iniciando atualização de cardápio");

        final boolean cardapioAtualizado = atualizarCardapioUseCase.atualizar(id, request);

        if (cardapioAtualizado) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCardapio(@PathVariable final Long id) {
        log.info("Iniciando deleção de cardápio");
        final boolean cardapioDeletado = deletarCardapioUseCase.executar(id);
        if (cardapioDeletado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}