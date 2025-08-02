package com.postech.techchallenge.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Getter
@Setter
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", unique = true)
    private Endereco endereco;

    private String tipoCozinha;
    private LocalTime horarioFuncionamentoInicial;
    private LocalTime horarioFuncionamentoFinal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", unique = true)
    private Usuario usuario;

    public Restaurante(String nome, Endereco endereco, String tipoCozinha,
                       LocalTime horarioFuncionamentoInicial, LocalTime horarioFuncionamentoFinal, Usuario usuario) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
        this.horarioFuncionamentoInicial = horarioFuncionamentoInicial;
        this.horarioFuncionamentoFinal = horarioFuncionamentoFinal;
        this.usuario = usuario;
    }

    public void atualizaDados(String nome, Endereco endereco, String tipoCozinha,
                              LocalTime horarioFuncionamentoInicial, LocalTime horarioFuncionamentoFinal, Usuario usuario) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
        this.horarioFuncionamentoInicial = horarioFuncionamentoInicial;
        this.horarioFuncionamentoFinal = horarioFuncionamentoFinal;
        this.usuario = usuario;
    }
}
