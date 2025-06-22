package com.acme.catchup.backendflowsense.domain.services;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Project;
import com.acme.catchup.backendflowsense.domain.model.queries.GetAllProjectsQuery;

import java.util.List;

public interface ProjectQueryService {
    List<Project> handle(GetAllProjectsQuery query);
} 