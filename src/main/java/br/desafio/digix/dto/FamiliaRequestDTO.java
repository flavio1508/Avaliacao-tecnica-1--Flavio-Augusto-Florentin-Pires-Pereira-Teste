package br.desafio.digix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamiliaRequestDTO {
    private int rendaTotal;
    private int numeroDependentes;
}
