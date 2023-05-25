package br.desafio.digix.dto;

import br.desafio.digix.models.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DependenteRequestDTO {
    private String nome;
    private Genero genero;
    private String dataDeNascimentoDependente;
}
