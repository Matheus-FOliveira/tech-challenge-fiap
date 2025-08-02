package com.postech.techchallenge.interfaces.swagger;

import org.springframework.http.ResponseEntity;

import com.postech.techchallenge.application.request.AtualizarRestauranteRequest;
import com.postech.techchallenge.application.request.CriarRestauranteRequest;
import com.postech.techchallenge.application.response.BuscarRestauranteResponse;
// import com.postech.techchallenge.application.response.BuscarTodosCardapiosPorRestauranteResponse;
import com.postech.techchallenge.application.response.BuscarTodosRestaurantesResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Restaurante", description = "CRUD para gerenciar restaurantes")
public interface RestauranteSwaggerOperations {

        // GET
        @Operation(summary = "Buscar todos os restaurantes", description = "Retorna todos os restaurantes")
        public ResponseEntity<BuscarTodosRestaurantesResponse> buscarTodosRestaurantes();

        // GET by ID
        @Operation(summary = "Buscar restaurante por ID", description = "Retorna um restaurante específico pelo ID")
        public ResponseEntity<BuscarRestauranteResponse> buscarRestaurante(Long id);

        // POST
        @Operation(summary = "Salvar restaurante", description = "Cria um novo restaurante")
        public ResponseEntity<Long> criarRestaurante(CriarRestauranteRequest request);

        // PUT
        @Operation(summary = "Atualizar restaurante", description = "Atualiza um restaurante existente")
        public ResponseEntity<Void> atualizarRestaurante(AtualizarRestauranteRequest request, Long id);

        // DELETE
        @Operation(summary = "Deletar restaurante", description = "Deleta um restaurante existente")
        public ResponseEntity<Void> deletarRestaurante(Long id);

        // public ResponseEntity<BuscarTodosCardapiosPorRestauranteResponse> buscarTodosCardapiosPorRestaurante(Long id);
}
