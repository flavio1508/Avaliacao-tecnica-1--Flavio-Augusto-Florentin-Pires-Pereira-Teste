package br.desafio.digix.service;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.desafio.digix.dto.ResponsavelFamiliaRequestDTO;
import br.desafio.digix.dto.ResponsavelFamiliaResponseDTO;
import br.desafio.digix.mapper.ResponsavelFamiliaMapper;
import br.desafio.digix.models.ResponsavelFamilia;
import br.desafio.digix.repository.ResponsavelFamiliaRepository;

@Service
public class ResponsavelFamiliaService {
    @Autowired
    private ResponsavelFamiliaRepository responsavelFamiliaRepository;

    @Autowired
    private ResponsavelFamiliaMapper responsavelFamiliaMapper;

    public ResponsavelFamiliaResponseDTO buscarPorId(Long id){
        return responsavelFamiliaMapper.responsavelParaResponsavelFamiliaResponseDTO(buscarResponsavelPeloId(id));
    }

    private ResponsavelFamilia buscarResponsavelPeloId(Long id) {
        Optional<ResponsavelFamilia> responsavelOptional = responsavelFamiliaRepository.findById(id);
        if(responsavelOptional.isEmpty()){
            throw new NoSuchElementException();
        }
        return responsavelOptional.get();
    }

    public ResponsavelFamilia cadastrar(ResponsavelFamiliaRequestDTO responsavelFamiliaRequestDTO) throws IOException{
        ResponsavelFamilia responsavelFamilia = responsavelFamiliaMapper.responsavelFamiliaRequestparaResponsavelFamilia(responsavelFamiliaRequestDTO);
        responsavelFamiliaRepository.save(responsavelFamilia);
        return responsavelFamiliaMapper.responsavelFamiliaRequestparaResponsavelFamilia(responsavelFamiliaRequestDTO);
    }
}
