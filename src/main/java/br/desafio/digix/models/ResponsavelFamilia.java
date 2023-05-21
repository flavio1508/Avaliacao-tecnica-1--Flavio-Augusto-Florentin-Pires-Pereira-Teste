package br.desafio.digix.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ResponsavelFamilia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false, length = 200)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private LocalDate dataDeNascimento;
    @Column(nullable = false)
    private Genero genero;
    @Column(nullable = false)
    private EstadoCivil estadoCivil;

    @OneToMany
    private List<Dependentes> dependentes;
    public ResponsavelFamilia(String nome, String email, String cpf, LocalDate dataDeNascimento, Genero genero, EstadoCivil estadoCivil) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        this.estadoCivil = estadoCivil;

    }

}
