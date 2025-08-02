package com.postech.techchallenge.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Getter
@Setter
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private float preco;
    private boolean disponibilidade;
    private String urlImagem;

    public Cardapio(String nome, String descricao, float preco, boolean disponibilidade, String urlImagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
        this.urlImagem = urlImagem;
    }

    public void atualizaDados(String nome, String descricao, float preco, boolean disponibilidade, String urlImagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
        this.urlImagem = urlImagem;
    }
    
}
