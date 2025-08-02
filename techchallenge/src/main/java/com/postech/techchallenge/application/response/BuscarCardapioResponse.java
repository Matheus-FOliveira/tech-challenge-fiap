package com.postech.techchallenge.application.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuscarCardapioResponse {
    private Long id;
    private String nome;
    private String descricao;
    private float preco;
    private boolean disponibilidade;
    private String urlImagem;

}
