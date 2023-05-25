package br.desafio.digix.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.desafio.digix.models.Dependentes;
import br.desafio.digix.models.Familia;

@Service
public class CalcularPontuacaoService {
    public List<Familia> ordenarFamilias(List<Familia> familias) {
        for (Familia familia : familias) {
            int pontuacao = calcularPontuacaoFamilia(familia);
            familia.setPontuacao(pontuacao);
        }

        familias.sort(Comparator.comparingInt(Familia::getPontuacao).reversed());

        return familias;
    }

    private int calcularPontuacaoFamilia(Familia familia) {
        int pontuacao = 0;

        int rendaTotal = familia.getRendaTotalFamilia();
        if (rendaTotal <= 900) {
            pontuacao += 5;
        } else if (rendaTotal <= 1500) {
            pontuacao += 3;
        }

        List<Dependentes> dependentes = familia.getDependentes();
        if (dependentes == null) {
            dependentes = new ArrayList<>();
        }
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
