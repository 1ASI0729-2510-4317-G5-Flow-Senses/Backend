package com.acme.catchup.backendflowsense.freelancer.services;

import com.acme.catchup.backendflowsense.freelancer.aggregates.Freelancer;
import com.acme.catchup.backendflowsense.freelancer.repositories.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreelancerCommandServiceImpl {
    @Autowired
    private FreelancerRepository repository;

    public Freelancer save(Freelancer freelancer) {
        return repository.save(freelancer);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
} 