package com.dasgupta.RateMyProfessor.institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    @Autowired
    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> getAll() {
        return (List<Institution>) institutionRepository.findAll();
    }

    public Optional<Institution> getById(Long id) {
        return institutionRepository.findById(id);
    }
}
