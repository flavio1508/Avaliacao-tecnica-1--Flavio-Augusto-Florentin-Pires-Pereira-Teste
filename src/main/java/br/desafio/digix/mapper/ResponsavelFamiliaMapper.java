package br.desafio.digix.mapper;

import br.desafio.digix.dto.ResponsavelFamiliaRequestDTO;
import br.desafio.digix.dto.ResponsavelFamiliaResponseDTO;
import br.desafio.digix.models.ResponsavelFamilia;

public interface ResponsavelFamiliaMapper {
        public ResponsavelFamiliaResponseDTO responsavelParaResponsavelFamiliaResponseDTO(
                        ResponsavelFamilia responsavelFamilia);

        public ResponsavelFamilia responsavelFamiliaRequestparaResponsavelFamilia(
                        ResponsavelFamiliaRequestDTO responsavelFamiliaRequestDTO);

}
//