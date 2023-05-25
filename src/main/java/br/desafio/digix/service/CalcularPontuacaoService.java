package br.desafio.digix.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.desafio.digix.models.Dependentes;
import br.desafio.digix.models.Familia;

@Service
public class CalcularPontuacaoService {
    public List<Familia> ordenarFamilias(List<Familia> familias) {
        // Calcular pontuação para cada família
        for (Familia familia : familias) {
            int pontuacao = calcularPontuacaoFamilia(familia);
            familia.setPontuacao(pontuacao);
        }

        // Ordenar famílias por pontuação de forma decrescente
        familias.sort(Comparator.comparingInt(Familia::getPontuacao).reversed());

        return familias;
    }

    private int calcularPontuacaoFamilia(Familia familia) {
        int pontuacao = 0;

        // Verificar renda total da família
        int rendaTotal = familia.getRendaTotalFamilia();
        if (rendaTotal <= 900) {
            pontuacao += 5;
        } else if (rendaTotal <= 1500) {
            pontuacao += 3;
        }

        // Verificar número de dependentes
        List<Dependentes> dependentes = familia.getDependentes();
        int numDependentes = calcularNumeroDependentes(dependentes);
        if (numDependentes >= 3) {
            pontuacao += 3;
        } else if (numDependentes >= 1) {
            pontuacao += 2;
        }

        return pontuacao;
    }

    private int calcularNumeroDependentes(List<Dependentes> dependentes) {
        int numDependentes = 0;
        for (Dependentes dependente : dependentes) {
            if (dependente.getId() < 18) {
                numDependentes++;
            }
        }
        return numDependentes;
    }
}
