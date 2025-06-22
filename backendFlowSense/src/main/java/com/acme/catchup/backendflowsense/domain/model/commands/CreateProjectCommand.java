package com.acme.catchup.backendflowsense.domain.model.commands;

import java.time.LocalDate;

public record CreateProjectCommand(
        String name,
        String description,
        LocalDate startDate,
        LocalDate endDate
) {
} 