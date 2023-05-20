// package br.desafio.digix.controller;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import br.desafio.digix.dto.FamiliaResponseDTO;
// import br.desafio.digix.models.Familia;
// import br.desafio.digix.service.FamiliaService;

// @RestController
// @RequestMapping("/familias")
// public class FamiliaController {
//     private final FamiliaService familiaService;
    
//     public FamiliaController(FamiliaService familiaService) {
//         this.familiaService = familiaService;
//     }
    
//     @PostMapping
//     public ResponseEntity<FamiliaResponseDTO> criarFamilia(@RequestBody FamiliaRequestDTO requestDTO) {
//         Familia familia = new Familia();
//         familia.setRendaTotal(requestDTO.getRendaTotal());
//         familia.setNumeroDependentes(requestDTO.getNumeroDependentes());
        
//         familiaService.calcularPontos(familia);
        
//         familia = familiaService.criarFamilia(familia); // Método do serviço para criar a família
        
//         FamiliaResponseDTO responseDTO = FamiliaResponseDTO.fromFamilia(familia);
        
//         return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
//     }
// }
