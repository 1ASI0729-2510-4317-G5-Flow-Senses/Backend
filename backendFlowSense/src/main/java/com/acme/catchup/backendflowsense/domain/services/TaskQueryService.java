package com.acme.catchup.backendflowsense.domain.services;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Task;
import com.acme.catchup.backendflowsense.domain.model.queries.GetAllTasksQuery;

import java.util.List;

public interface TaskQueryService {
    List<Task> handle(GetAllTasksQuery query);
} 