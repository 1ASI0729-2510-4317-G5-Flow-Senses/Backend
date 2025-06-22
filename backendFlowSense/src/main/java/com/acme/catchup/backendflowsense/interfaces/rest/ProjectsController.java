package com.acme.catchup.backendflowsense.interfaces.rest;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Project;
import com.acme.catchup.backendflowsense.domain.model.commands.CreateProjectCommand;
import com.acme.catchup.backendflowsense.domain.model.queries.GetAllProjectsQuery;
import com.acme.catchup.backendflowsense.domain.services.ProjectCommandService;
import com.acme.catchup.backendflowsense.domain.services.ProjectQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectsController {

    private final ProjectCommandService projectCommandService;
    private final ProjectQueryService projectQueryService;

    public ProjectsController(ProjectCommandService projectCommandService, ProjectQueryService projectQueryService) {
        this.projectCommandService = projectCommandService;
        this.projectQueryService = projectQueryService;
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody CreateProjectCommand command) {
        var project = projectCommandService.handle(command);
        return project.map(p -> new ResponseEntity<>(p, HttpStatus.CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        var query = new GetAllProjectsQuery();
        var projects = projectQueryService.handle(query);
        return ResponseEntity.ok(projects);
    }
} 