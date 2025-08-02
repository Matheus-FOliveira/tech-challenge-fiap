package com.postech.techchallenge.domain;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String userLogin;
    private String senha;
    private LocalDate ultimaAlteracao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_usuario_id", referencedColumnName = "id", unique = true)
    private TipoUsuario tipoUsuario;

    public Usuario(String nome, Endereco endereco, String senha, String userLogin, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.senha = senha;
        this.userLogin = userLogin;
        this.email = email;
    }

    public void atualizaDados(String nome, Endereco endereco, String userLogin, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.userLogin = userLogin;
        this.email = email;
    }

    public void atualizaSenha(String novaSenha) {
        this.senha = novaSenha;
    }

}
