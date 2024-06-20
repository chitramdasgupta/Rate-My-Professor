package com.dasgupta.RateMyProfessor.degree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DegreeService {
    private final DegreeRepository degreeRepository;

    @Autowired
    public DegreeService(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    public List<Degree> getAll() {
        return (List<Degree>) degreeRepository.findAll();
    }

    public Optional<Degree> getById(Long id) {
        return degreeRepository.findById(id);
    }
}
