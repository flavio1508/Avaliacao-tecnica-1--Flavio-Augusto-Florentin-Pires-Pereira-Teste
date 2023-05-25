package br.desafio.digix.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import br.desafio.digix.Utils.JsonUtil;
import br.desafio.digix.dto.DependenteRequestDTO;
import br.desafio.digix.dto.DependenteResponseDTO;
import br.desafio.digix.models.Dependentes;
import br.desafio.digix.models.Genero;
import br.desafio.digix.repository.DependenteRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class DependenteTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private DependenteRepository dependenteRepository;

	@BeforeEach
	@AfterEach
	void deleteDados() {
		dependenteRepository.deleteAll();

	};

	@Test
	void deve_incluir_um_dependente() throws Exception {
		int quantitadeEsperado = 1;

		DependenteRequestDTO dependenteRequestDTO = new DependenteRequestDTO("Flavio", Genero.MASCULINO, "2012-08-15");

		mockMvc.perform(post("/api/v1/dependente")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(dependenteRequestDTO)))
				.andExpect(status().isCreated());

		List<Dependentes> dependentesRetornados = dependenteRepository
				.findByNomeContainingIgnoreCase(dependenteRequestDTO.getNome());
		Assertions.assertThat(dependentesRetornados.size()).isEqualTo(quantitadeEsperado);
		Assertions.assertThat(dependentesRetornados.stream().map(Dependentes::getNome).toList())
				.contains(dependenteRequestDTO.getNome());

	}

	@Test
	void deve_buscar_um_dependente_pelo_id() throws Exception {
		LocalDate dataDeNascimento = LocalDate.of(2013, 07, 19);

		Dependentes dependentes = Dependentes.builder().nome("Flavio").genero(Genero.MASCULINO)
				.dataDeNascimentoDependente(dataDeNascimento).build();
		dependenteRepository.save(dependentes);

		MvcResult mvcResult = mockMvc.perform(get("/api/v1/dependente/" + dependentes.getId())).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);

		String content = mvcResult.getResponse().getContentAsString();
		DependenteResponseDTO criancaDTO = JsonUtil.mapFromJsonModuleJavaTime(content, DependenteResponseDTO.class);

		Assertions.assertThat(dependentes.getId()).isEqualTo(criancaDTO.getId());
	}

	@Test
	void deve_remover_um_dependente_pelo_id() throws Exception {
		LocalDate dataDeNascimento = LocalDate.of(2012, 07, 19);
		Dependentes dependentes = Dependentes.builder().nome("Flavio").genero(Genero.MASCULINO)
				.dataDeNascimentoDependente(dataDeNascimento).build();
		dependenteRepository.saveAll(Arrays.asList(dependentes));

		this.mockMvc
				.perform(delete("/api/v1/dependente/" + dependentes.getId()))
				.andExpect(status().isOk());

		List<Dependentes> dependentesRetornados = dependenteRepository
				.findByNomeContainingIgnoreCase(dependentes.getNome());

		Assertions.assertThat(dependentesRetornados).isEmpty();
	}
}
