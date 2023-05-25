package br.desafio.digix.service;

import java.util.ArrayList;
import java.util.List;

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
     void deve_trazer_pontuacao() {
        // Criação das famílias
        Familia familia1 = new Familia();
        familia1.setRendaTotalFamilia(1000);
        familia1.setDependentes(criarListaDependentes(2));

        Familia familia2 = new Familia();
        familia2.setRendaTotalFamilia(1500);
        familia2.setDependentes(criarListaDependentes(4));

        Familia familia3 = new Familia();
        familia3.setRendaTotalFamilia(800);
        familia3.setDependentes(criarListaDependentes(1));

        // Criação da lista de famílias
        List<Familia> familias = new ArrayList<>();
        familias.add(familia1);
        familias.add(familia2);
        familias.add(familia3);

        // Instanciação do serviço
        CalcularPontuacaoService service = new CalcularPontuacaoService();

        // Ordenação das famílias por pontuação
        List<Familia> familiasOrdenadas = service.ordenarFamilias(familias);

        // Exibição do resultado ordenado
        for (Familia familia : familiasOrdenadas) {
            System.out.println("Pontuação: " + familia.getPontuacao());
            System.out.println("Renda Total: " + familia.getRendaTotalFamilia());
            System.out.println("Número de Dependentes: " + familia.getDependentes().size());
            System.out.println("---------------------------");
        }
    }

   // Método auxiliar para criar uma lista de dependentes com idade inferior a 18 anos
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
