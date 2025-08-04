package com.postech.techchallenge.infrastructure;

import com.postech.techchallenge.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RestauranteRepositoryTest {

    @Autowired
    private RestauranteRepository restauranteRepository;

    private Restaurante restaurante;

    @BeforeEach
    public void setup() {
        Endereco enderecoRestaurante = new Endereco(null, "Av. Central", "Loja 1", 12345678, "São Paulo", "SP");

        Endereco enderecoUsuario = new Endereco(null, "Rua 2", "Apto 101", 87654321, "Rio", "RJ");
        TipoUsuario tipoUsuario = new TipoUsuario(null, "ADMIN");

        Usuario usuario = new Usuario(
                "João da Silva",
                enderecoUsuario,
                "senha123",
                "joaosilva",
                "joao@email.com",
                tipoUsuario
        );

        restaurante = new Restaurante(
                "Restaurante Teste",
                enderecoRestaurante,
                "Brasileira",
                LocalTime.of(10, 0),
                LocalTime.of(22, 0),
                usuario
        );

        restaurante = restauranteRepository.save(restaurante);
    }

    @Test
    public void testFindAll() {
        List<Restaurante> list = restauranteRepository.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    public void testFindById() {
        Optional<Restaurante> found = restauranteRepository.findById(restaurante.getId());
        assertTrue(found.isPresent());
        assertEquals("Restaurante Teste", found.get().getNome());
    }

    @Test
    public void testSave() {
        Endereco enderecoRestaurante = new Endereco(null, "Rua Nova", "Loja 2", 11111111, "Curitiba", "PR");
        Endereco enderecoUsuario = new Endereco(null, "Rua Nova", "Casa", 22222222, "Curitiba", "PR");
        TipoUsuario tipoUsuario = new TipoUsuario(null, "CLIENTE");

        Usuario usuario = new Usuario(
                "Maria Oliveira",
                enderecoUsuario,
                "123456",
                "maria",
                "maria@email.com",
                tipoUsuario
        );

        Restaurante novo = new Restaurante(
                "Restaurante da Maria",
                enderecoRestaurante,
                "Japonesa",
                LocalTime.of(12, 0),
                LocalTime.of(23, 0),
                usuario
        );

        Restaurante saved = restauranteRepository.save(novo);

        assertNotNull(saved.getId());
        assertEquals("Restaurante da Maria", saved.getNome());
    }

    @Test
    public void testDeleteById() {
        restauranteRepository.deleteById(restaurante.getId());
        Optional<Restaurante> deleted = restauranteRepository.findById(restaurante.getId());
        assertFalse(deleted.isPresent());
    }

    @Test
    public void testUpdate() {
        Endereco novoEndereco = new Endereco(null, "Av. Paulista", "Sala 33", 33333333, "São Paulo", "SP");
        Endereco novoEnderecoUsuario = new Endereco(null, "Rua 10", "Apto 303", 44444444, "Campinas", "SP");
        TipoUsuario novoTipo = new TipoUsuario(null, "GESTOR");

        Usuario novoUsuario = new Usuario(
                "Pedro Souza",
                novoEnderecoUsuario,
                "novaSenha",
                "pedrosouza",
                "pedro@email.com",
                novoTipo
        );

        restaurante.atualizaDados(
                "Restaurante Atualizado",
                novoEndereco,
                "Italiana",
                LocalTime.of(9, 0),
                LocalTime.of(21, 0),
                novoUsuario
        );

        Restaurante updated = restauranteRepository.save(restaurante);

        assertEquals("Restaurante Atualizado", updated.getNome());
        assertEquals("Av. Paulista", updated.getEndereco().getEnderecoLinha1());
        assertEquals("Italiana", updated.getTipoCozinha());
        assertEquals("pedrosouza", updated.getUsuario().getUserLogin());
        assertEquals("GESTOR", updated.getUsuario().getTipoUsuario().getObservacao());
    }
}
