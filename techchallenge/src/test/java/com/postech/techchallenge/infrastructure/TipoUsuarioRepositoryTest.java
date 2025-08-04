package com.postech.techchallenge.infrastructure;

import com.postech.techchallenge.domain.TipoUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TipoUsuarioRepositoryTest {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    private TipoUsuario tipoUsuario;

    @BeforeEach
    public void setup() {
        tipoUsuario = new TipoUsuario("ADMIN", "Acesso total");
        tipoUsuario = tipoUsuarioRepository.save(tipoUsuario);
    }

    @Test
    public void testFindAll() {
        List<TipoUsuario> list = tipoUsuarioRepository.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    public void testFindById() {
        Optional<TipoUsuario> found = tipoUsuarioRepository.findById(tipoUsuario.getId());
        assertTrue(found.isPresent());
        assertEquals("ADMIN", found.get().getNome());
    }

    @Test
    public void testSave() {
        TipoUsuario novo = new TipoUsuario("CLIENTE", "Acesso restrito");
        TipoUsuario saved = tipoUsuarioRepository.save(novo);

        assertNotNull(saved.getId());
        assertEquals("CLIENTE", saved.getNome());
        assertEquals("Acesso restrito", saved.getObservacao());
    }

    @Test
    public void testDeleteById() {
        tipoUsuarioRepository.deleteById(tipoUsuario.getId());
        Optional<TipoUsuario> deleted = tipoUsuarioRepository.findById(tipoUsuario.getId());
        assertFalse(deleted.isPresent());
    }

    @Test
    public void testUpdate() {
        tipoUsuario.atualizaDados("GESTOR", "Gerencia operações");
        TipoUsuario updated = tipoUsuarioRepository.save(tipoUsuario);

        assertEquals("GESTOR", updated.getNome());
        assertEquals("Gerencia operações", updated.getObservacao());
    }
}
