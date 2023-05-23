package br.desafio.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.desafio.digix.Utils.DataConvert;

@SpringBootTest
public class ResponsavelFamiliaServiceTest {
    @Autowired
    private ResponsavelFamiliaService responsavelFamiliaService;

    @Test
    void deve_converte_data_em_string_para_timestamp() {
        String dataEmString = "2002-07-19";

        LocalDate dataEsperada = LocalDate.of(2002, 07, 19);

        LocalDate dataAtual = DataConvert.obterData(dataEmString);

        assertEquals(dataEsperada, dataAtual);
    }

}
//
