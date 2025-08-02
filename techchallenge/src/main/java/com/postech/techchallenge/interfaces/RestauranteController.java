package com.postech.techchallenge.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.postech.techchallenge.interfaces.swagger.RestauranteSwaggerOperations;

import lombok.extern.slf4j.Slf4j;

import com.postech.techchallenge.application.AtualizarRestauranteUseCase;
import com.postech.techchallenge.application.BuscarRestauranteUseCase;
import com.postech.techchallenge.application.BuscarTodosCardapiosPorRestauranteUseCase;
import com.postech.techchallenge.application.BuscarTodosRestaurantesUseCase;
import com.postech.techchallenge.application.CriarRestauranteUseCase;
import com.postech.techchallenge.application.DeletarRestauranteUseCase;
import com.postech.techchallenge.application.request.AtualizarRestauranteRequest;
import com.postech.techchallenge.application.request.CriarRestauranteRequest;
import com.postech.techchallenge.application.response.BuscarRestauranteResponse;
import com.postech.techchallenge.application.response.BuscarTodosRestaurantesResponse;

@Slf4j
@RestController
@RequestMapping("/api/v1/restaurantes")
public class RestauranteController implements RestauranteSwaggerOperations {

    private final CriarRestauranteUseCase criarRestauranteUseCase;
    private final AtualizarRestauranteUseCase atualizarRestauranteUseCase;
    private final DeletarRestauranteUseCase deletarRestauranteUseCase;
    private final BuscarRestauranteUseCase buscarRestauranteUseCase;
    private final BuscarTodosRestaurantesUseCase buscarTodosRestaurantesUseCase;
    // private final BuscarTodosCardapiosPorRestauranteUseCase buscarTodosCardapiosPorRestauranteUseCase;

    public RestauranteController(
        CriarRestauranteUseCase criarRestauranteUseCase,
        AtualizarRestauranteUseCase atualizarRestauranteUseCase,
        DeletarRestauranteUseCase deletarRestauranteUseCase,
        BuscarRestauranteUseCase buscarRestauranteUseCase,
        BuscarTodosRestaurantesUseCase buscarTodosRestaurantesUseCase,
        BuscarTodosCardapiosPorRestauranteUseCase buscarTodosCardapiosPorRestauranteUseCase
    ) {
        this.criarRestauranteUseCase = criarRestauranteUseCase;
        this.atualizarRestauranteUseCase = atualizarRestauranteUseCase;
        this.deletarRestauranteUseCase = deletarRestauranteUseCase;
        this.buscarRestauranteUseCase = buscarRestauranteUseCase;
        this.buscarTodosRestaurantesUseCase = buscarTodosRestaurantesUseCase;
        // this.buscarTodosCardapiosPorRestauranteUseCase = buscarTodosCardapiosPorRestauranteUseCase;
    }

    @GetMapping
    public ResponseEntity<BuscarTodosRestaurantesResponse> buscarTodosRestaurantes() {
        log.info("Iniciando busca de todos os restaurantes");
        final BuscarTodosRestaurantesResponse response = buscarTodosRestaurantesUseCase.executar();
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscarRestauranteResponse> buscarRestaurante(@PathVariable Long id) {
        log.info("Iniciando busca de um restaurante pelo ID: {}", id);
        final BuscarRestauranteResponse response = buscarRestauranteUseCase.executar(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Long> criarRestaurante(@RequestBody CriarRestauranteRequest request) {
        log.info("Iniciando criação de restaurante: {}", request);
        final Long idNovoRestaurante = criarRestauranteUseCase.executar(request);
        if (idNovoRestaurante != null) {
            return ResponseEntity.ok(idNovoRestaurante);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarRestaurante(
            @RequestBody AtualizarRestauranteRequest request,
            @PathVariable Long id) {
        log.info("Iniciando atualização de restaurante com ID: {}", id);
        final boolean restauranteAtualizado = atualizarRestauranteUseCase.executar(id, request);
        if (restauranteAtualizado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRestaurante(@PathVariable Long id) {
        log.info("Iniciando deleção de restaurante com ID: {}", id);
        final boolean restauranteDeletado = deletarRestauranteUseCase.executar(id);
        if (restauranteDeletado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    // @GetMapping("/{id}/cardapios")
    // public ResponseEntity<BuscarTodosCardapiosPorRestauranteResponse> buscarTodosCardapiosPorRestaurante(
    //         @PathVariable Long id) {
    //     log.info("Iniciando busca de todos os cardápios de um restaurante com ID: {}", id);
    //     final BuscarTodosCardapiosPorRestauranteResponse response = buscarTodosCardapiosPorRestauranteUseCase.executar(id);
    //     if (response != null) {
    //         return ResponseEntity.ok(response);
    //     }
    //     return ResponseEntity.notFound().build();
    // }
}
