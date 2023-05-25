package br.desafio.digix.mapper;

import br.desafio.digix.dto.DependenteRequestDTO;
import br.desafio.digix.dto.DependenteResponseDTO;
import br.desafio.digix.models.Dependentes;

public interface DependenteMapper {
        public DependenteResponseDTO dependenteParaDependenteResponseDTO(
                        Dependentes dependentes);

        public Dependentes dependenteFamiliaRequestparaDependenteFamilia(
                        DependenteRequestDTO dependenteRequestDTO);
}
