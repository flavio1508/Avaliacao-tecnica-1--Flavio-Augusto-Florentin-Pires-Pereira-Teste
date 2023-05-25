package br.desafio.digix.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ResponsavelFamiliaTest {
    @Test
    void deve_criar_um_responsavel_da_familia_com_genero() {
        Genero genero = Genero.FEMININO;

        ResponsavelFamilia responsavelFamilia = ResponsavelFamilia.builder().genero(genero).build();

        assertThat(responsavelFamilia.getGenero()).isEqualTo(genero);
    }

    @Test
    void deve_criar_um_responsavel_da_familia_com_data_de_nascimento() {
        LocalDate dataDeNascimento = LocalDate.of(2000, 04, 05);

        ResponsavelFamilia responsavelFamilia = ResponsavelFamilia.builder().dataDeNascimento(dataDeNascimento).build();

        assertThat(responsavelFamilia.getDataDeNascimento()).isEqualTo(dataDeNascimento);
    }

}
