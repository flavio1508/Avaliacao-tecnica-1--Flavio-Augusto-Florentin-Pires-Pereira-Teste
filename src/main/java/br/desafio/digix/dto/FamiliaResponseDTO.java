package br.desafio.digix.dto;

import br.desafio.digix.models.Familia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamiliaResponseDTO {
    private Long id;
    private int rendaTotal;
    private int numeroDependentes;
    private int pontos;

    public FamiliaResponseDTO(Familia familia) {
        this.id = familia.getId();
        this.rendaTotal = familia.getRendaTotal();
        this.numeroDependentes = familia.getNumeroDependentes();
        this.pontos = familia.getPontos();
    }
}
