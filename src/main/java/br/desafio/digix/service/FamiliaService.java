// package br.desafio.digix.service;

// import java.util.Comparator;
// import java.util.List;

// import org.springframework.stereotype.Repository;

// import br.desafio.digix.dto.FamiliaRequestDTO;
// import br.desafio.digix.models.Familia;
// import br.desafio.digix.repository.FamiliaRepository;

// @Repository
// public class FamiliaService {
//     private final FamiliaRepository familiaRepository;
    
//     public FamiliaService(FamiliaRepository familiaRepository) {
//         this.familiaRepository = familiaRepository;
//     }
    
//     public Familia criarFamilia(FamiliaRequestDTO requestDTO) {
//         Familia familia = new Familia();
//         familia.setRendaTotal(requestDTO.getRendaTotal());
//         familia.setNumeroDependentes(requestDTO.getNumeroDependentes());
        
//         calcularPontos(familia);
        
//         return familiaRepository.save(familia);
//     }
    
//     public List<FamiliaDTO> obterFamiliasAptas() {
//         List<Familia> familias = familiaRepository.findAll();
        
//         for (Familia familia : familias) {
//             calcularPontos(familia);
//         }
        
//         familias.sort(Comparator.comparingInt(Familia::getPontos).reversed());
        
//         return FamiliaDTO.convertToDTOList(familias);
//     }
    
//     private void calcularPontos(Familia familia) {
//         int pontos = 0;
        
//         if (familia.getRendaTotal() <= 900) {
//             pontos += 5;
//         } else if (familia.getRendaTotal() <= 1500) {
//             pontos += 3;
//         }
        
//         if (familia.getNumeroDependentes() >= 3) {
//             pontos += 3;
//         } else if (familia.getNumeroDependentes() >= 1) {
//             pontos += 2;
//         }
        
//         familia.setPontos(pontos);
//     }
// }
