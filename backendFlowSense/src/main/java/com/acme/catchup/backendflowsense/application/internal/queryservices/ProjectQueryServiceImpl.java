package com.acme.catchup.backendflowsense.application.internal.queryservices;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Project;
import com.acme.catchup.backendflowsense.domain.model.queries.GetAllProjectsQuery;
import com.acme.catchup.backendflowsense.domain.repositories.ProjectRepository;
import com.acme.catchup.backendflowsense.domain.services.ProjectQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectQueryServiceImpl implements ProjectQueryService {

    private final ProjectRepository projectRepository;

    public ProjectQueryServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> handle(GetAllProjectsQuery query) {
        return projectRepository.findAll();
    }
} 