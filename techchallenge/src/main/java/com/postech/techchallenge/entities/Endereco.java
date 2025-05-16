package com.postech.techchallenge.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private String enderecoLinha1;
    private String enderecoLinha2;
    private Integer cep;
    private String cidade;
    private String estado;
}
