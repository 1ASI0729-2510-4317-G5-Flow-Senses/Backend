package com.acme.catchup.backendflowsense.interfaces.rest.resources;

import com.acme.catchup.backendflowsense.domain.model.valueobjects.TaskPriority;
import com.acme.catchup.backendflowsense.domain.model.valueobjects.TaskStatus;

import java.time.LocalDate;

public record TaskResource(
        Long id,
        String name,
        String description,
        LocalDate deadline,
        TaskStatus status,
        TaskPriority priority,
        String projectName,
        String assigneeName
) {
} 