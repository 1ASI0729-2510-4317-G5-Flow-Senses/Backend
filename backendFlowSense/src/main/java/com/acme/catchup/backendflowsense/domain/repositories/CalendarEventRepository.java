package com.acme.catchup.backendflowsense.domain.repositories;

import com.acme.catchup.backendflowsense.domain.model.aggregates.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {
} 