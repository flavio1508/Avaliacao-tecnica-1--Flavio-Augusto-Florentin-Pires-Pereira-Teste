package br.desafio.digix.service;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.desafio.digix.Utils.DataConvert;
import br.desafio.digix.dto.DependenteRequestDTO;
import br.desafio.digix.dto.DependenteResponseDTO;
import br.desafio.digix.mapper.DependenteMapper;
import br.desafio.digix.models.Dependentes;
import br.desafio.digix.repository.DependenteRepository;

@Service
public class DependenteService {
    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private DependenteMapper dependenteMapper;

    public DependenteResponseDTO buscarPorId(Long id) {
        return dependenteMapper.dependenteParaDependenteResponseDTO(buscarDependentePeloId(id));
    }

    private Dependentes buscarDependentePeloId(Long id) {
        Optional<Dependentes> dependenteOptional = dependenteRepository.findById(id);
        if (dependenteOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        return dependenteOptional.get();
    }

    public DependenteResponseDTO cadastrar(DependenteRequestDTO dependenteRequestDTO) throws IOException {
        Dependentes dependentes = dependenteMapper.dependenteFamiliaRequestparaDependenteFamilia(dependenteRequestDTO);
        dependenteRepository.save(dependentes);
        return dependenteMapper.dependenteParaDependenteResponseDTO(dependentes);
    }

    public DependenteResponseDTO alterar(DependenteRequestDTO dependenteRequestDTO, long id) {
        Dependentes dependenteParaAlterar = buscarDependentePeloId(id);
        dependenteParaAlterar.setNome(dependenteRequestDTO.getNome());
        dependenteParaAlterar.setGenero(dependenteRequestDTO.getGenero());
        dependenteParaAlterar.setDataDeNascimentoDependente(
                DataConvert.obterData(dependenteRequestDTO.getDataDeNascimentoDependente()));

        dependenteRepository.save(dependenteParaAlterar);

        return dependenteMapper.dependenteParaDependenteResponseDTO(dependenteParaAlterar);
    }

}
//