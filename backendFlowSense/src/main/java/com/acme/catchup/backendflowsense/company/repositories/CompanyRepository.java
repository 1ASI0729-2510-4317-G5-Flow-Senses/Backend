package com.acme.catchup.backendflowsense.company.repositories;

import com.acme.catchup.backendflowsense.company.aggregates.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {} 