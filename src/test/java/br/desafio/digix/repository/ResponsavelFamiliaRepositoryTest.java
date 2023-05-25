package br.desafio.digix.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import br.desafio.digix.models.EstadoCivil;
import br.desafio.digix.models.Genero;
import br.desafio.digix.models.ResponsavelFamilia;

@DataJpaTest
public class ResponsavelFamiliaRepositoryTest {
    @Autowired
    private ResponsavelFamiliaRepository responsavelFamiliaRepository;

    @BeforeEach
    void setUp() {
        responsavelFamiliaRepository.deleteAll();
    }

    @Test
    void deve_registrar_um_responsavel_familia_no_banco_com_id() throws Exception {
        LocalDate dataDeNascimento = LocalDate.of(2000, 04, 05);
        ResponsavelFamilia responsavelFamilia = ResponsavelFamilia.builder().nome("Flavio").email("flavio@gmail.com")
                .cpf("012.235.123.47").dataDeNascimento(dataDeNascimento).genero(Genero.MASCULINO)
                .estadoCivil(EstadoCivil.CASADO).build();

        responsavelFamiliaRepository.save(responsavelFamilia);

        assertThat(responsavelFamilia.getId()).isNotNull();
    }
}
