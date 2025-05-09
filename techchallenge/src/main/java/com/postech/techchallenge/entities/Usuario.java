package com.postech.techchallenge.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Usuario {  
    
    private Long id;
    
    private String nome;
    private String email;
    private String userLogin;
    private String senha;
    private LocalDate ultimaAlteracao;
    private String endereco;
}
