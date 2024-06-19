package com.dasgupta.RateMyProfessor.degree;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepository extends CrudRepository<Degree, Long> {
}
