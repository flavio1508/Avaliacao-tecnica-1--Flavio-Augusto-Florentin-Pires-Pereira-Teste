package br.desafio.digix.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Dependentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String nome;
    @Column(nullable = false)
    private Genero genero;
    @Column(nullable = false)
    private LocalDate dataDeNascimentoDependente;

    @ManyToOne
    private ResponsavelFamilia responsavelFamilia;

    public Dependentes(String nome, Genero genero, LocalDate dataDeNascimentoDependente,
            ResponsavelFamilia responsavelFamilia) {
        this.nome = nome;
        this.genero = genero;
        this.dataDeNascimentoDependente = dataDeNascimentoDependente;
        this.responsavelFamilia = responsavelFamilia;
    }

    @PrePersist
    void verificarIdade() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataDezoitoAnosAtras = dataAtual.minusYears(18);

        if (dataDeNascimentoDependente.isAfter(dataDezoitoAnosAtras)) {
            throw new IllegalArgumentException("O dependente deve ser menor de 18 anos.");
        }
    }

}
