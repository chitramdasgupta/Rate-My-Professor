package com.dasgupta.RateMyProfessor.institution;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends CrudRepository<Institution, Long> {
}
