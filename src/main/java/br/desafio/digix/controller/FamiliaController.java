package br.desafio.digix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.desafio.digix.dto.FamiliaResponseDTO;
import br.desafio.digix.models.Familia;
import br.desafio.digix.repository.FamiliaRepository;
import br.desafio.digix.service.CalcularPontuacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/familias")
public class FamiliaController {

    private final FamiliaRepository familiaRepository;
    private final CalcularPontuacaoService calcularPontuacaoService;

    @Autowired
    public FamiliaController(FamiliaRepository familiaRepository, CalcularPontuacaoService calcularPontuacaoService) {
        this.familiaRepository = familiaRepository;
        this.calcularPontuacaoService = calcularPontuacaoService;
    }

    @Operation(summary = "Buscar familias ordenadas por pontuação ")
    @ApiResponse(responseCode = "200", description = "Retorna a lista de famílias ordenadas por pontuação")
    @GetMapping
    public List<FamiliaResponseDTO> listarFamiliasOrdenadasPorPontuacao() {
        List<Familia> familias = familiaRepository.findAll();
        familias = calcularPontuacaoService.ordenarFamilias(familias);
        return FamiliaResponseDTO.fromFamilias(familias);
    }

}
