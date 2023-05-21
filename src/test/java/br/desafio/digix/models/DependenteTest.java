package br.desafio.digix.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DependenteTest {

    @Test
    public void test_validacao_idade_dependente_menor_de_dezoito_anos() {
        // Cria um responsável com a data de nascimento mais recente possível (hoje - 18
        // anos)
        LocalDate dataDeNascimentoResponsavel = LocalDate.now().minusYears(18);
        ResponsavelFamilia responsavel = new ResponsavelFamilia("Nome Responsável", "email@example.com", "123456789",
                dataDeNascimentoResponsavel, Genero.MASCULINO, EstadoCivil.CASADO);

        // Cria um dependente com a data de nascimento posterior à data limite (maior de
        // 18 anos)
        LocalDate dataDeNascimentoDependente = LocalDate.now().minusYears(18).plusDays(1);
        Dependentes dependente = new Dependentes("Nome Dependente", Genero.FEMININO, dataDeNascimentoDependente,
                responsavel);

        // Tenta salvar o dependente, deve lançar uma exceção
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dependente.verificarIdade();
        });
    }

    @Test
    public void test_validacao_idade_dependente_maior_de_dezoito_anos() {
        // Cria um responsável com a data de nascimento mais recente possível (hoje - 18
        // anos)
        LocalDate dataDeNascimentoResponsavel = LocalDate.now().minusYears(18);
        ResponsavelFamilia responsavel = new ResponsavelFamilia("Nome Responsável", "email@example.com", "123456789",
                dataDeNascimentoResponsavel, Genero.MASCULINO, EstadoCivil.CASADO);

        // Cria um dependente com a data de nascimento anterior à data limite (menor de
        // 18 anos)
        LocalDate dataDeNascimentoDependente = LocalDate.now().minusYears(18).minusDays(1);
        Dependentes dependente = new Dependentes("Nome Dependente", Genero.FEMININO, dataDeNascimentoDependente,
                responsavel);

        // Tenta salvar o dependente, não deve lançar exceção
        Assertions.assertDoesNotThrow(() -> {
            dependente.verificarIdade();
        });
    }
}
