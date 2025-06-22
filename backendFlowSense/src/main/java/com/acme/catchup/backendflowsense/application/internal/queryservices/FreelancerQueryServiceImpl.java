package com.acme.catchup.backendflowsense.application.internal.queryservices;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Freelancer;
import com.acme.catchup.backendflowsense.domain.repositories.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FreelancerQueryServiceImpl {
    @Autowired
    private FreelancerRepository repository;

    public List<Freelancer> findAll() {
        return repository.findAll();
    }

    public Optional<Freelancer> findById(Long id) {
        return repository.findById(id);
    }
} 