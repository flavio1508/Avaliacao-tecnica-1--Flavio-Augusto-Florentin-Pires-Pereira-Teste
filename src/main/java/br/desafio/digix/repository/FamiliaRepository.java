package br.desafio.digix.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.desafio.digix.models.Familia;

@Repository
public interface FamiliaRepository extends CrudRepository<Familia, Long> {
    public List<Familia> findAll();

}
