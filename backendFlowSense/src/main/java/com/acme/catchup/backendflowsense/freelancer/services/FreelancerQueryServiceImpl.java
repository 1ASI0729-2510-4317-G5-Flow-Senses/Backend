package com.acme.catchup.backendflowsense.freelancer.services;

import com.acme.catchup.backendflowsense.freelancer.aggregates.Freelancer;
import com.acme.catchup.backendflowsense.freelancer.repositories.FreelancerRepository;
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