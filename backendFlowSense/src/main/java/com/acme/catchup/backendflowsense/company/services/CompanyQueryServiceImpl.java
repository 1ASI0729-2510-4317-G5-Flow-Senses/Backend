package com.acme.catchup.backendflowsense.company.services;

import com.acme.catchup.backendflowsense.company.aggregates.Company;
import com.acme.catchup.backendflowsense.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyQueryServiceImpl {
    @Autowired
    private CompanyRepository repository;

    public List<Company> findAll() {
        return repository.findAll();
    }

    public Optional<Company> findById(Long id) {
        return repository.findById(id);
    }
} 