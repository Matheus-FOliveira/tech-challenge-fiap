package com.postech.techchallenge.application.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoRequest {

    @Schema(example = "Rua das Flores, 123")
    private String enderecoLinha1;

    @Schema(example = "Apto 201")
    private String enderecoLinha2;

    @Schema(example = "12345678")
    private Integer cep;

    @Schema(example = "São Paulo")
    private String cidade;

    @Schema(example = "SP")
    private String estado;
}
