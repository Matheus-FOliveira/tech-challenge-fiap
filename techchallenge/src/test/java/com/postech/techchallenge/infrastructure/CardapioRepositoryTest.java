package com.postech.techchallenge.infrastructure;

import com.postech.techchallenge.domain.Cardapio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CardapioRepositoryTest {

    @Autowired
    private CardapioRepository cardapioRepository;

    private Cardapio cardapio;

    @BeforeEach
    public void setup() {
        cardapio = new Cardapio(
                "Pizza",
                "Pizza de calabresa",
                29.90f,
                true,
                "http://imagem.com/pizza.jpg"
        );
        cardapio = cardapioRepository.save(cardapio);
    }

    @Test
    public void testFindAll() {
        List<Cardapio> list = cardapioRepository.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    public void testFindById() {
        Optional<Cardapio> found = cardapioRepository.findById(cardapio.getId());
        assertTrue(found.isPresent());
        assertEquals("Pizza", found.get().getNome());
    }

    @Test
    public void testSave() {
        Cardapio novo = new Cardapio(
                "Hambúrguer",
                "Com queijo e bacon",
                19.99f,
                true,
                "http://imagem.com/burger.jpg"
        );
        Cardapio saved = cardapioRepository.save(novo);

        assertNotNull(saved.getId());
        assertEquals("Hambúrguer", saved.getNome());
    }

    @Test
    public void testDeleteById() {
        cardapioRepository.deleteById(cardapio.getId());
        Optional<Cardapio> deleted = cardapioRepository.findById(cardapio.getId());
        assertFalse(deleted.isPresent());
    }

    @Test
    public void testUpdate() {
        cardapio.atualizaDados(
                "Pizza Atualizada",
                "Com borda recheada",
                34.90f,
                false,
                "http://imagem.com/pizza-atualizada.jpg"
        );
        Cardapio updated = cardapioRepository.save(cardapio);

        assertEquals("Pizza Atualizada", updated.getNome());
        assertEquals("Com borda recheada", updated.getDescricao());
        assertEquals(34.90f, updated.getPreco(), 0.001);
        assertFalse(updated.isDisponibilidade());
        assertEquals("http://imagem.com/pizza-atualizada.jpg", updated.getUrlImagem());
    }
}
