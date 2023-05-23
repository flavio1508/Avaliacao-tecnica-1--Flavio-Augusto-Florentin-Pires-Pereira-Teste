package br.desafio.digix.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int rendaTotal;
    
    private int numeroDependentes;
    
    private int pontos;
}
// import java.util.List;

// public class Familia {
//     private ResponsavelFamilia responsavelFamilia;
//     private List<Dependentes> dependentes;

//     public Familia(ResponsavelFamilia responsavelFamilia, List<Dependentes> dependentes) {
//         this.responsavelFamilia = responsavelFamilia;
//         this.dependentes = dependentes;
//     }

//     public ResponsavelFamilia getResponsavelFamilia() {
//         return responsavelFamilia;
//     }

//     public List<Dependentes> getDependentes() {
//         return dependentes;
//     }

//     public int calcularPontuacao() {
//         // Implemente aqui a lógica para calcular a pontuação da família
//         // Você pode chamar o método calcularPontuacao() de ResponsavelFamilia

//         int pontuacaoTotal = responsavelFamilia.calcularPontuacao();
//         return pontuacaoTotal;
//     }
// }
// import java.util.List;

// public class Familia {
//     private ResponsavelFamilia responsavelFamilia;
//     private List<Dependentes> dependentes;

//     public Familia(ResponsavelFamilia responsavelFamilia, List<Dependentes> dependentes) {
//         this.responsavelFamilia = responsavelFamilia;
//         this.dependentes = dependentes;
//     }

//     public ResponsavelFamilia getResponsavelFamilia() {
//         return responsavelFamilia;
//     }

//     public List<Dependentes> getDependentes() {
//         return dependentes;
//     }

//     public int calcularPontuacao() {
//         int pontuacao = 0;

//         // Critério 1: Renda total da família
//         double rendaTotal = responsavelFamilia.getRendaTotalFamilia();
//         if (rendaTotal <= 900) {
//             pontuacao += 5;
//         } else if (rendaTotal <= 1500) {
//             pontuacao += 3;
//         }

//         // Critério 2: Número de dependentes
//         int numeroDependentes = contarDependentes();
//         if (numeroDependentes >= 3) {
//             pontuacao += 3;
//         } else if (numeroDependentes >= 1) {
//             pontuacao += 2;
//         }

//         return pontuacao;
//     }

//     private int contarDependentes() {
//         int count = 0;
//         for (Dependentes dependente : dependentes) {
//             if (dependente.getIdade() < 18) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

