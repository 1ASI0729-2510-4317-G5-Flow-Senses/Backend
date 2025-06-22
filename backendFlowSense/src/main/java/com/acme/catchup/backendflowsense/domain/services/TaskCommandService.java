package com.acme.catchup.backendflowsense.domain.services;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Task;
import com.acme.catchup.backendflowsense.domain.model.commands.CreateTaskCommand;
import com.acme.catchup.backendflowsense.domain.model.commands.DeleteTaskCommand;

import java.util.Optional;

public interface TaskCommandService {
    Optional<Task> handle(CreateTaskCommand command);
    void handle(DeleteTaskCommand command);
} 