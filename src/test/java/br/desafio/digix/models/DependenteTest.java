package br.desafio.digix.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class DependenteTest {
    @Test
    void deve_criar_um_dependente_com_genero() {
        Genero genero = Genero.FEMININO;

        Dependentes dependentes = Dependentes.builder().genero(genero).build();

        assertThat(dependentes.getGenero()).isEqualTo(genero);
    }

    @Test
    void deve_criar_um_dependente_com_data_de_nascimento() {
        LocalDate dataDeNascimentoDependente = LocalDate.of(2000, 04, 05);

        Dependentes dependentes = Dependentes.builder().dataDeNascimentoDependente(dataDeNascimentoDependente).build();

        assertThat(dependentes.getDataDeNascimentoDependente()).isEqualTo(dataDeNascimentoDependente);
    }
}
