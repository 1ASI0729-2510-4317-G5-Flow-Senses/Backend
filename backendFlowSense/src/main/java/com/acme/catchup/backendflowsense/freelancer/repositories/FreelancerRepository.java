package com.acme.catchup.backendflowsense.freelancer.repositories;

import com.acme.catchup.backendflowsense.freelancer.aggregates.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {} 