package com.acme.catchup.backendflowsense.domain.repositories;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
} 