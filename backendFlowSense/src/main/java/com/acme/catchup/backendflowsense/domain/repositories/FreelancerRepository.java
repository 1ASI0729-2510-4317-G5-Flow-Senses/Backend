package com.acme.catchup.backendflowsense.domain.repositories;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {} 