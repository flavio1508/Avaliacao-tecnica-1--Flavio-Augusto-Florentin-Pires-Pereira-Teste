package br.desafio.digix.mapper;

import br.desafio.digix.dto.ResponsavelFamiliaResponseDTO;
import br.desafio.digix.models.Familia;

public interface ResponsavelFamiliaMapper {
    public ResponsavelFamiliaResponseDTO responsavelParaResponsavelFamiliaResponseDTO(Familia familia);  
    public Familia responsavelRequestparaResponsavel(ResponsavelFamiliaRequestDTO responsavelFamiliaRequestDTO);

}
