package br.desafio.digix.dto;

import java.time.LocalDate;

import br.desafio.digix.models.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsavelFamiliaRequestDTO {
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataDeNascimento;
    private Genero genero;

}
