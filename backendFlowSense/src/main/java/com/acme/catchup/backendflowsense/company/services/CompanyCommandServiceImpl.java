package com.acme.catchup.backendflowsense.company.services;

import com.acme.catchup.backendflowsense.company.aggregates.Company;
import com.acme.catchup.backendflowsense.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyCommandServiceImpl {
    @Autowired
    private CompanyRepository repository;

    public Company save(Company company) {
        return repository.save(company);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
} 