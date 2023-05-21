package br.desafio.digix.mapper;

import br.desafio.digix.Utils.DataConvert;
import br.desafio.digix.dto.ResponsavelFamiliaRequestDTO;
import br.desafio.digix.dto.ResponsavelFamiliaResponseDTO;
import br.desafio.digix.models.ResponsavelFamilia;

public class ResponsavelFamiliaMapperImpl implements ResponsavelFamiliaMapper {
    @Override
    public ResponsavelFamiliaResponseDTO responsavelParaResponsavelFamiliaResponseDTO(
            ResponsavelFamilia responsavelFamilia) {
        return new ResponsavelFamiliaResponseDTO(responsavelFamilia.getId(),
                responsavelFamilia.getNome(),
                responsavelFamilia.getEmail(),
                responsavelFamilia.getCpf(),
                responsavelFamilia.getDataDeNascimento(),
                responsavelFamilia.getGenero()

        );
    }

    @Override
    public ResponsavelFamilia responsavelFamiliaRequestparaResponsavelFamilia(
            ResponsavelFamiliaRequestDTO responsavelFamiliaRequestDTO) {
        return ResponsavelFamilia.builder()
                .nome(responsavelFamiliaRequestDTO.getNome())
                .email(responsavelFamiliaRequestDTO.getEmail())
                .cpf(responsavelFamiliaRequestDTO.getCpf())
                .dataDeNascimento(DataConvert.obterData(responsavelFamiliaRequestDTO.getDataDeNascimento()))
                .genero(responsavelFamiliaRequestDTO.getGenero())
                .build();
    }
}
