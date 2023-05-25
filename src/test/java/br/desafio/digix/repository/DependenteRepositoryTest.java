package br.desafio.digix.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.desafio.digix.models.Dependentes;
import br.desafio.digix.models.Genero;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

@DataJpaTest
public class DependenteRepositoryTest {
    @Autowired
    private DependenteRepository dependenteRepository;

    @BeforeEach
    void setUp() {
        dependenteRepository.deleteAll();
    }

    @Test
    void deve_registrar_um_dependente_no_banco_com_id() throws Exception {
        LocalDate dataDeNascimento = LocalDate.of(2000, 04, 05);
        Dependentes dependentes = Dependentes.builder().nome("Flavio").genero(Genero.MASCULINO).dataDeNascimentoDependente(dataDeNascimento).build();

        dependenteRepository.save(dependentes);

        assertThat(dependentes.getId()).isNotNull();
    }
}
