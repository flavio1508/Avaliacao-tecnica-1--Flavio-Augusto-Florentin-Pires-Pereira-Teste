package br.desafio.digix.dto;

import java.time.LocalDate;

import br.desafio.digix.models.EstadoCivil;
import br.desafio.digix.models.Genero;
import br.desafio.digix.models.ResponsavelFamilia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponsavelFamiliaResponseDTO {
    private Long Id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataDeNascimento;
    private Genero genero;
    private EstadoCivil estadoCivil;

    public ResponsavelFamiliaResponseDTO(ResponsavelFamilia responsavelFamilia) {
        this.Id = responsavelFamilia.getId();
        this.nome = responsavelFamilia.getNome();
        this.email = responsavelFamilia.getEmail();
        this.cpf = responsavelFamilia.getCpf();
        this.dataDeNascimento = responsavelFamilia.getDataDeNascimento();
        this.genero = responsavelFamilia.getGenero();
        this.estadoCivil = responsavelFamilia.getEstadoCivil();
    }
}
