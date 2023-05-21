package br.desafio.digix.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.desafio.digix.Utils.DataConvert;
import br.desafio.digix.dto.ResponsavelFamiliaRequestDTO;
import br.desafio.digix.dto.ResponsavelFamiliaResponseDTO;

@SpringBootTest
public class ResponsavelFamiliaServiceTest {
    @Autowired
    private ResponsavelFamiliaService responsavelFamiliaService;
    
    @Test
    void deve_converte_data_em_string_para_timestamp(){
        String dataEmString = "2002-07-19";
        
        LocalDate dataEsperada = LocalDate.of(2002, 07, 19);

        LocalDate dataAtual = DataConvert.obterData(dataEmString);

        assertEquals(dataEsperada, dataAtual);
    }

    @Test
    void deve_cadastrar_uma_crianca(){
        ResponsavelFamiliaRequestDTO responsavelFamiliaRequestDTO = new ResponsavelFamiliaRequestDTO(null, null, null, null, null, null);

        ResponsavelFamiliaResponseDTO responsavelFamiliaResponseDTO = responsavelFamiliaService.cadastrar(responsavelFamiliaRequestDTO);

        assertThat(responsavelFamiliaResponseDTO.getId()).isNotNull();
    }
}
