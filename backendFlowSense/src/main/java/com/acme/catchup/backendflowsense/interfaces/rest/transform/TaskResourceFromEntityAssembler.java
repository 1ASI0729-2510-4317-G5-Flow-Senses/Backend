package com.acme.catchup.backendflowsense.interfaces.rest.transform;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Task;
import com.acme.catchup.backendflowsense.interfaces.rest.resources.TaskResource;

public class TaskResourceFromEntityAssembler {
    public static TaskResource toResourceFromEntity(Task entity) {
        return new TaskResource(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getDeadline(),
                entity.getStatus(),
                entity.getPriority(),
                entity.getProject().getName(),
                entity.getAssignee().getFirstName() + " " + entity.getAssignee().getLastName()
        );
    }
} 