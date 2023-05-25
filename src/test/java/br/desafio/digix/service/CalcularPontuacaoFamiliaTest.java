package br.desafio.digix.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.desafio.digix.models.Dependentes;
import br.desafio.digix.models.Familia;

@SpringBootTest
public class CalcularPontuacaoFamiliaTest {
    @Autowired
    CalcularPontuacaoService calcularPontuacaoService;

    @Test
    void ordenar_familias_por_pontuacao() {
        Familia familia1 = new Familia();
        familia1.setPontuacao(3);
        familia1.setRendaTotalFamilia(1200);

        Familia familia2 = new Familia();
        familia2.setPontuacao(5);
        familia2.setRendaTotalFamilia(800);

        List<Familia> familias = Arrays.asList(familia1, familia2);

        List<Familia> familiasOrdenadas = calcularPontuacaoService.ordenarFamilias(familias);

        List<Familia> familiasEsperadas = Arrays.asList(familia2, familia1);
        Assertions.assertThat(familiasOrdenadas).isEqualTo(familiasEsperadas);
    }

    @Test
    void teste_de_calculo_de_pontuação_das_familias() {
        Familia familia1 = new Familia();
        familia1.setRendaTotalFamilia(1000);
        familia1.setDependentes(criarListaDependentes(2));

        Familia familia2 = new Familia();
        familia2.setRendaTotalFamilia(1500);
        familia2.setDependentes(criarListaDependentes(4));

        Familia familia3 = new Familia();
        familia3.setRendaTotalFamilia(800);
        familia3.setDependentes(criarListaDependentes(1));

        List<Familia> familias = new ArrayList<>();
        familias.add(familia1);
        familias.add(familia2);
        familias.add(familia3);

        CalcularPontuacaoService service = new CalcularPontuacaoService();

        List<Familia> familiasOrdenadas = service.ordenarFamilias(familias);

        for (Familia familia : familiasOrdenadas) {
            System.out.println("Pontuação: " + familia.getPontuacao());
            System.out.println("Renda Total: " + familia.getRendaTotalFamilia());
            System.out.println("Número de Dependentes: " + familia.getDependentes().size());
            System.out.println("---------------------------");
        }
    }

    private static List<Dependentes> criarListaDependentes(int quantidade) {
        List<Dependentes> dependentes = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            Dependentes dependente = new Dependentes();
            dependente.setId(i < 3 ? (long) (i + 1) : 20L);
            dependentes.add(dependente);
        }
        return dependentes;
    }

}
