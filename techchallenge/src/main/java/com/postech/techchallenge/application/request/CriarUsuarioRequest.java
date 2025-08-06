package com.postech.techchallenge.application.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarUsuarioRequest {

    @Schema(example = "João da Silva")
    private String nome;

    @Schema(example = "joao@email.com")
    private String email;

    @Schema(example = "joaosilva")
    private String userLogin;

    @Schema(example = "senha123")
    private String senha;

    private Long enderecoId;

    @Schema(example = "1")
    private Long tipoUsuarioId;
}
