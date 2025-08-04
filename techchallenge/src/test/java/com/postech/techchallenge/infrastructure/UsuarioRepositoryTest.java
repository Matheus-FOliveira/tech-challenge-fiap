package com.postech.techchallenge.infrastructure;

import com.postech.techchallenge.domain.Endereco;
import com.postech.techchallenge.domain.TipoUsuario;
import com.postech.techchallenge.domain.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;

    @BeforeEach
    public void setup() {
        Endereco endereco = new Endereco(null, "Rua 1", "Apto 101", 12345678, "Cidade X", "Estado Y");
        TipoUsuario tipoUsuario = new TipoUsuario(null, "CLIENTE", "Usuário com acesso restrito");

        usuario = new Usuario(
                "João Silva",
                endereco,
                "senha123",
                "joaosilva",
                "joao@email.com",
                tipoUsuario
        );
        usuario.setUltimaAlteracao(LocalDate.now());

        usuario = usuarioRepository.save(usuario);
    }

    @Test
    public void testFindAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        assertFalse(usuarios.isEmpty());
    }

    @Test
    public void testFindById() {
        Optional<Usuario> found = usuarioRepository.findById(usuario.getId());
        assertTrue(found.isPresent());
        assertEquals("João Silva", found.get().getNome());
    }

    @Test
    public void testSave() {
        Endereco endereco = new Endereco(null, "Rua 2", "Casa", 98765432, "Cidade Y", "Estado Z");
        TipoUsuario tipo = new TipoUsuario(null, "ADMIN", "Controle total");

        Usuario novo = new Usuario(
                "Maria Oliveira",
                endereco,
                "senha456",
                "mariaoliveira",
                "maria@email.com",
                tipo
        );
        novo.setUltimaAlteracao(LocalDate.now());

        Usuario saved = usuarioRepository.save(novo);
        assertNotNull(saved.getId());
        assertEquals("Maria Oliveira", saved.getNome());
    }

    @Test
    public void testDeleteById() {
        usuarioRepository.deleteById(usuario.getId());
        Optional<Usuario> deleted = usuarioRepository.findById(usuario.getId());
        assertFalse(deleted.isPresent());
    }

    @Test
    public void testUpdate() {
        Endereco novoEndereco = new Endereco(null, "Rua Nova", "Bloco B", 12312312, "Cidade Nova", "Estado Novo");
        TipoUsuario novoTipo = new TipoUsuario(null, "GESTOR", "Responsável pela gestão");

        usuario.atualizaDados("João Atualizado", novoEndereco, "joaoatualizado", "joao.novo@email.com", novoTipo);
        usuario.setUltimaAlteracao(LocalDate.now());

        Usuario atualizado = usuarioRepository.save(usuario);

        assertEquals("João Atualizado", atualizado.getNome());
        assertEquals("joao.novo@email.com", atualizado.getEmail());
        assertEquals("GESTOR", atualizado.getTipoUsuario().getNome());
        assertEquals("Cidade Nova", atualizado.getEndereco().getCidade());
    }

    @Test
    public void testAtualizaSenha() {
        usuario.atualizaSenha("novasenha");
        Usuario atualizado = usuarioRepository.save(usuario);

        assertEquals("novasenha", atualizado.getSenha());
    }
}
