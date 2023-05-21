package br.desafio.digix.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.desafio.digix.models.ResponsavelFamilia;


@Repository
public interface ResponsavelFamiliaRepository extends CrudRepository<ResponsavelFamilia, Long> {
   List<ResponsavelFamilia> findByNomeContainingIgnoreCase(String nome);
   public List<ResponsavelFamilia> findAll();
    
}
