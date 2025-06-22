package com.acme.catchup.backendflowsense.application.internal.queryservices;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Task;
import com.acme.catchup.backendflowsense.domain.model.queries.GetAllTasksQuery;
import com.acme.catchup.backendflowsense.domain.repositories.TaskRepository;
import com.acme.catchup.backendflowsense.domain.services.TaskQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskQueryServiceImpl implements TaskQueryService {

    private final TaskRepository taskRepository;

    public TaskQueryServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> handle(GetAllTasksQuery query) {
        return taskRepository.findAll();
    }
} 