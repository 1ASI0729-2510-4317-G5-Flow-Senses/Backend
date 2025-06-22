package com.acme.catchup.backendflowsense.domain.model.aggregates;

import com.acme.catchup.backendflowsense.domain.model.valueobjects.TaskPriority;
import com.acme.catchup.backendflowsense.domain.model.valueobjects.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    public Task() {
    }

    public Task(String name, String description, LocalDate deadline, TaskPriority priority, Project project, User assignee) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.project = project;
        this.assignee = assignee;
        this.priority = priority;
        this.status = TaskStatus.PENDING;
    }
} 