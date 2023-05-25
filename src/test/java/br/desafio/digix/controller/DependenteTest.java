package br.desafio.digix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import br.desafio.digix.dto.DependenteRequestDTO;
import br.desafio.digix.models.Dependentes;
import br.desafio.digix.models.Genero;
import br.desafio.digix.repository.DependenteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import br.desafio.digix.Utils.JsonUtil;
import java.util.List;
import org.assertj.core.api.Assertions;




@SpringBootTest
@AutoConfigureMockMvc
public class DependenteTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DependenteRepository dependenteRepository;

    @BeforeEach
    @AfterEach
    public void deleteDados() {
        dependenteRepository.deleteAll();

    };

    @Test
	public void deve_incluir_um_responsavel_familia() throws Exception  {
		int quantitadeEsperado = 1;
		
		DependenteRequestDTO dependenteRequestDTO = new DependenteRequestDTO("Flavio", Genero.MASCULINO, "15/08/200");

		mockMvc.perform(post("/api/v1/responsavelFamilia")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(dependenteRequestDTO)))
				.andExpect(status().isCreated());

		List<Dependentes> dependentesRetornados = dependenteRepository.findByNomeContainingIgnoreCase(dependenteRequestDTO.getNome());
		Assertions.assertThat(dependentesRetornados.size()).isEqualTo(quantitadeEsperado);
		Assertions.assertThat(dependentesRetornados.stream().map(Dependentes::getNome).toList()).contains(dependenteRequestDTO.getNome());

	}

	@Test
	void deve_buscar_um_responsavel_familia_pelo_id() throws Exception {
        LocalDate dataDeNascimento = LocalDate.of(2002, 07, 19);

		ResponsavelFamilia responsavelFamilia = ResponsavelFamilia.builder().nome("Flavio").email("flavio@gmail.com").cpf("045.123.254-45").dataDeNascimento(dataDeNascimento).genero(Genero.MASCULINO).estadoCivil(EstadoCivil.SOLTEIRO).build();
		responsavelFamiliaRepository.save(responsavelFamilia);
		
		MvcResult mvcResult = mockMvc.perform(get("/api/v1/responsavelFamilia/" + responsavelFamilia.getId())).andReturn();

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
