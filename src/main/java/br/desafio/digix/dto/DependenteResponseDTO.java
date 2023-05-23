package br.desafio.digix.dto;

import java.time.LocalDate;

import br.desafio.digix.models.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DependenteResponseDTO {
    private Long id;
    private String nome;
    private Genero genero;
    private LocalDate dataDeNascimentoDependente;
}
