package br.desafio.digix.dto;

import java.util.ArrayList;
import java.util.List;

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
    private String nomeResponsavelFamilia;
    private int quantidadeDeDependentes;
    private int rendaTotalFamilia;
    private int pontuacao;

    public static List<FamiliaResponseDTO> fromFamilias(List<Familia> familias) {
        List<FamiliaResponseDTO> familiaResponseDTOs = new ArrayList<>();
        for (Familia familia : familias) {
            FamiliaResponseDTO familiaResponseDTO = new FamiliaResponseDTO();
            familiaResponseDTO.setId(familia.getId());
            familiaResponseDTO.setNomeResponsavelFamilia(familia.getResponsavelFamilia().getNome());
            familiaResponseDTO.setQuantidadeDeDependentes(familia.getDependentes().size());
            familiaResponseDTO.setRendaTotalFamilia(familia.getRendaTotalFamilia());
            familiaResponseDTO.setPontuacao(familia.getPontuacao());
            familiaResponseDTOs.add(familiaResponseDTO);
        }
        return familiaResponseDTOs;
    }

}
//