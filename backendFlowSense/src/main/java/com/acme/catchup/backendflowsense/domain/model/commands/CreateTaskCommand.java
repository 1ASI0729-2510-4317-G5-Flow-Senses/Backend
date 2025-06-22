package com.acme.catchup.backendflowsense.domain.model.commands;

import com.acme.catchup.backendflowsense.domain.model.valueobjects.TaskPriority;

import java.time.LocalDate;

public record CreateTaskCommand(
        String name,
        String description,
        LocalDate deadline,
        TaskPriority priority,
        Long projectId,
        Long assigneeId
) {
} 