package com.acme.catchup.backendflowsense.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class TimeTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public TimeTracking() {
    }

    public TimeTracking(Task task, User user, LocalDateTime startTime, LocalDateTime endTime) {
        this.task = task;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
    }
} 