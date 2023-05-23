package br.desafio.digix.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.desafio.digix.models.Dependentes;

@Repository
public interface DependenteRepository extends CrudRepository<Dependentes, Long> {
    List<Dependentes> findByNomeContainingIgnoreCase(String nome);

    public List<Dependentes> findAll();
}
