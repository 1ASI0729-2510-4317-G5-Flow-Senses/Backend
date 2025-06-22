package com.acme.catchup.backendflowsense.interfaces.rest;

import com.acme.catchup.backendflowsense.domain.model.commands.CreateTaskCommand;
import com.acme.catchup.backendflowsense.domain.model.commands.DeleteTaskCommand;
import com.acme.catchup.backendflowsense.domain.model.queries.GetAllTasksQuery;
import com.acme.catchup.backendflowsense.domain.services.TaskCommandService;
import com.acme.catchup.backendflowsense.domain.services.TaskQueryService;
import com.acme.catchup.backendflowsense.interfaces.rest.resources.TaskResource;
import com.acme.catchup.backendflowsense.interfaces.rest.transform.TaskResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/tasks")
public class TasksController {

    private final TaskCommandService taskCommandService;
    private final TaskQueryService taskQueryService;

    public TasksController(TaskCommandService taskCommandService, TaskQueryService taskQueryService) {
        this.taskCommandService = taskCommandService;
        this.taskQueryService = taskQueryService;
    }

    @PostMapping
    public ResponseEntity<TaskResource> createTask(@RequestBody CreateTaskCommand command) {
        var task = taskCommandService.handle(command);
        return task.map(t -> new ResponseEntity<>(TaskResourceFromEntityAssembler.toResourceFromEntity(t), HttpStatus.CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<TaskResource>> getAllTasks() {
        var getAllTasksQuery = new GetAllTasksQuery();
        var tasks = taskQueryService.handle(getAllTasksQuery);
        var taskResources = tasks.stream()
                .map(TaskResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(taskResources);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        var deleteTaskCommand = new DeleteTaskCommand(taskId);
        taskCommandService.handle(deleteTaskCommand);
        return ResponseEntity.ok("Task with id " + taskId + " deleted successfully");
    }
} 