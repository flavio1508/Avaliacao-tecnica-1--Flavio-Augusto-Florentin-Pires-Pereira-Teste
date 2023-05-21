package br.desafio.digix.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import br.desafio.digix.Utils.JsonUtil;
import br.desafio.digix.dto.ResponsavelFamiliaRequestDTO;
import br.desafio.digix.dto.ResponsavelFamiliaResponseDTO;
import br.desafio.digix.models.EstadoCivil;
import br.desafio.digix.models.Genero;
import br.desafio.digix.models.ResponsavelFamilia;
import br.desafio.digix.repository.ResponsavelFamiliaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.assertj.core.api.Assertions;



@SpringBootTest
@AutoConfigureMockMvc
public class ResponsavelFamiliaTest {
        
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ResponsavelFamiliaRepository responsavelFamiliaRepository;
    
    @BeforeEach
	@AfterEach
	public void deleteDados() {
		responsavelFamiliaRepository.deleteAll();

	};

    @Test
	public void deve_incluir_um_responsavel_familia() throws Exception  {
		int quantitadeEsperado = 1;
		
		ResponsavelFamiliaRequestDTO responsavelFamiliaRequestDTO = new ResponsavelFamiliaRequestDTO("Maria", "maria@gmail.com", "021.365.012-15", "20/12/2000", Genero.FEMININO, EstadoCivil.SOLTEIRO);

		mockMvc.perform(post("/api/v1/responsavelFamilia")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(responsavelFamiliaRequestDTO)))
				.andExpect(status().isCreated());

		List<ResponsavelFamilia> responsavelFamiliaRetornados = responsavelFamiliaRepository.findByNomeContainingIgnoreCase(responsavelFamiliaRequestDTO.getNome());
		Assertions.assertThat(responsavelFamiliaRetornados.size()).isEqualTo(quantitadeEsperado);
		Assertions.assertThat(responsavelFamiliaRetornados.stream().map(ResponsavelFamilia::getNome).toList()).contains(responsavelFamiliaRequestDTO.getNome());

	}

	@Test
	void deve_buscar_um_responsavel_familia_pelo_id() throws Exception {
        LocalDate dataDeNascimento = LocalDate.of(2002, 07, 19);

		ResponsavelFamilia responsavelFamilia = ResponsavelFamilia.builder().nome("Flavio").email("flavio@gmail.com").cpf("045.123.254-45").dataDeNascimento(dataDeNascimento).genero(Genero.MASCULINO).estadoCivil(EstadoCivil.SOLTEIRO).build();
		responsavelFamiliaRepository.save(responsavelFamilia);
		
		MvcResult mvcResult = mockMvc.perform(get("/api/v1/responsavelFamilia" + responsavelFamilia.getId())).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);

		String content = mvcResult.getResponse().getContentAsString();
		ResponsavelFamiliaResponseDTO criancaDTO = JsonUtil.mapFromJsonModuleJavaTime(content, ResponsavelFamiliaResponseDTO.class);

		Assertions.assertThat(responsavelFamilia.getId()).isEqualTo(criancaDTO.getId());
	}	

    @Test
	public void deve_remover_uma_crianca_pelo_id() throws Exception {
        LocalDate dataDeNascimento = LocalDate.of(2002, 07, 19);
		ResponsavelFamilia responsavelFamilia = ResponsavelFamilia.builder().nome("Flavio").email("flavio@gmail.com").cpf("045.123.254-45").dataDeNascimento(dataDeNascimento).genero(Genero.MASCULINO).estadoCivil(EstadoCivil.SOLTEIRO).build();
		responsavelFamiliaRepository.saveAll(Arrays.asList(responsavelFamilia));

		this.mockMvc
				.perform(delete("/api/v1/responsavelFamilia/" + responsavelFamilia.getId()))
				.andExpect(status().isOk());

		List<ResponsavelFamilia> responsavelFamiliaRetornados = responsavelFamiliaRepository.findByNomeContainingIgnoreCase(responsavelFamilia.getNome());

		Assertions.assertThat(responsavelFamiliaRetornados).isEmpty();
	}
}
