package br.desafio.digix.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ResponsavelFamiliaTest {
    @Test
    void deve_criar_um_responsavel_da_familia_com_genero() {
        Genero genero =  Genero.FEMININO;
        
        ResponsavelFamilia responsavelFamilia = ResponsavelFamilia.builder().genero(genero).build();

        assertThat(responsavelFamilia.getGenero()).isEqualTo(genero);
    }

}
