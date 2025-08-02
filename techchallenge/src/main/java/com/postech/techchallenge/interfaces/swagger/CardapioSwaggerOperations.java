package com.postech.techchallenge.interfaces.swagger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.postech.techchallenge.application.request.CriarCardapioRequest;
import com.postech.techchallenge.application.response.BuscarCardapioResponse;
import com.postech.techchallenge.application.response.BuscarTodosCardapiosResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cardápio", description = "CRUD para gerenciar cardápios")
public interface CardapioSwaggerOperations {

        // GET
        @Operation(summary = "Buscar todos os cardápios", description = "Retorna todos os cardápios")
        public ResponseEntity<BuscarTodosCardapiosResponse> buscarTodosCardapios();

        // GET by ID
        @Operation(summary = "Buscar cardápio por ID", description = "Retorna um cardápio específico pelo ID")
        public ResponseEntity<BuscarCardapioResponse> buscarCardapio(Long id);

        // POST
        @Operation(summary = "Salvar cardápio", description = "Cria um novo cardápio")
        public ResponseEntity<Long> criarCardapio(
                        @RequestBody CriarCardapioRequest request);

        // PUT
        @Operation(summary = "Atualizar cardápio", description = "Atualiza um cardápio existente")
        public ResponseEntity<Void> atualizarCardapio(
                        @RequestBody CriarCardapioRequest request, Long id);

        // DELETE
        @Operation(summary = "Deletar cardápio", description = "Deleta um cardápio existente")
        public ResponseEntity<Void> deletarCardapio(Long id);
        
}
