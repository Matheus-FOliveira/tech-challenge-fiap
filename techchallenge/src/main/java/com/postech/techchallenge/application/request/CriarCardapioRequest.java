package com.postech.techchallenge.application.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CriarCardapioRequest {

    private String nome;
    private String descricao;
    private float preco;
    private boolean disponibilidade;
    private String urlImagem;
    
}
