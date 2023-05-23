package br.desafio.digix.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ResponsavelFamilia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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

    public ResponsavelFamilia(String nome, String email, String cpf, LocalDate dataDeNascimento, Genero genero,
            EstadoCivil estadoCivil) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        this.estadoCivil = estadoCivil;

    }

}
