package com.acme.catchup.backendflowsense.application.internal.commandservices;

import com.acme.catchup.backendflowsense.domain.model.aggregates.Task;
import com.acme.catchup.backendflowsense.domain.model.commands.CreateTaskCommand;
import com.acme.catchup.backendflowsense.domain.model.commands.DeleteTaskCommand;
import com.acme.catchup.backendflowsense.domain.repositories.ProjectRepository;
import com.acme.catchup.backendflowsense.domain.repositories.TaskRepository;
import com.acme.catchup.backendflowsense.domain.repositories.UserRepository;
import com.acme.catchup.backendflowsense.domain.services.TaskCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskCommandServiceImpl implements TaskCommandService {
    private static final Logger logger = LoggerFactory.getLogger(TaskCommandServiceImpl.class);

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public TaskCommandServiceImpl(TaskRepository taskRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Task> handle(CreateTaskCommand command) {
        var project = projectRepository.findById(command.projectId());
        var user = userRepository.findById(command.assigneeId());

        if (project.isEmpty() || user.isEmpty()) {
            return Optional.empty();
        }

        var task = new Task(command.name(), command.description(), command.deadline(), command.priority(), project.get(), user.get());
        try {
            taskRepository.save(task);
        } catch (Exception e) {
            logger.error("Error while saving task: {}", e.getMessage(), e);
            return Optional.empty();
        }
        return Optional.of(task);
    }

    @Override
    public void handle(DeleteTaskCommand command) {
        if (!taskRepository.existsById(command.taskId())) {
            throw new IllegalArgumentException("Task not found");
        }
        taskRepository.deleteById(command.taskId());
    }
} 