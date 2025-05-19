package com.postech.techchallenge.usecases;

import com.postech.techchallenge.entities.Usuario;
import com.postech.techchallenge.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AtualizarSenhaUseCase {

    private UsuarioRepository usuarioRepository;

    public boolean executar(final Long id, final String novaSenha) {
        final Usuario usuarioAtualizado = usuarioRepository.updateSenha(id, novaSenha);

        /*
        * TODO
        *  deve buscar o usuario, e se encontrar atualizar a senha
        *  se nao encontrar deve retornar erro
        * */
    }

}
