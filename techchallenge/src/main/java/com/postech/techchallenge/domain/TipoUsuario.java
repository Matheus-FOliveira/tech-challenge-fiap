package com.postech.techchallenge.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Getter
@Setter
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String observacao;

    public TipoUsuario(String nome, String observacao) {
        this.nome = nome;
        this.observacao = observacao;
    }      

    public void atualizaDados(String nome, String observacao) {
        this.nome = nome;
        this.observacao = observacao;
    }   

}