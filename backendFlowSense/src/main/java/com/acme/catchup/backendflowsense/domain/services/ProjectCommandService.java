package com.acme.catchup.backendflowsense.domain.services;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Project;
import com.acme.catchup.backendflowsense.domain.model.commands.CreateProjectCommand;

import java.util.Optional;

public interface ProjectCommandService {
    Optional<Project> handle(CreateProjectCommand command);
} 