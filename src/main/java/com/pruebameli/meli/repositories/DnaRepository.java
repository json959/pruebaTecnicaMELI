package com.pruebameli.meli.repositories;

import com.pruebameli.meli.models.DnaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends CrudRepository<DnaModel, Long> {
}
