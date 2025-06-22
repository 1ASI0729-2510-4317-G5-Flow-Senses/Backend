package com.acme.catchup.backendflowsense.application.internal.commandservices;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Project;
import com.acme.catchup.backendflowsense.domain.model.commands.CreateProjectCommand;
import com.acme.catchup.backendflowsense.domain.repositories.ProjectRepository;
import com.acme.catchup.backendflowsense.domain.services.ProjectCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectCommandServiceImpl implements ProjectCommandService {

    private final ProjectRepository projectRepository;

    public ProjectCommandServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> handle(CreateProjectCommand command) {
        var project = new Project(command.name(), command.description(), command.startDate(), command.endDate());
        try {
            projectRepository.save(project);
        } catch (Exception e) {
            // Log the exception here
            return Optional.empty();
        }
        return Optional.of(project);
    }
} 