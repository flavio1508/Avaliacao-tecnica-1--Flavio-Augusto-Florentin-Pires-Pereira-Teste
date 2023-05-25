package br.desafio.digix.mapper;

import org.springframework.stereotype.Component;

import br.desafio.digix.Utils.DataConvert;
import br.desafio.digix.dto.DependenteRequestDTO;
import br.desafio.digix.dto.DependenteResponseDTO;
import br.desafio.digix.models.Dependentes;

@Component
public class DependenteMapperImpl implements DependenteMapper {
    @Override
    public DependenteResponseDTO dependenteParaDependenteResponseDTO(Dependentes dependentes) {
        return new DependenteResponseDTO(
                dependentes.getId(),
                dependentes.getNome(),
                dependentes.getGenero(),
                dependentes.getDataDeNascimentoDependente());
    }

    @Override
    public Dependentes dependenteFamiliaRequestparaDependenteFamilia(
            DependenteRequestDTO dependenteRequestDTO) {
        return Dependentes.builder()
                .nome(dependenteRequestDTO.getNome())
                .genero(dependenteRequestDTO.getGenero())
                .dataDeNascimentoDependente(DataConvert.obterData(dependenteRequestDTO.getDataDeNascimentoDependente()))
                .build();
    }

}
