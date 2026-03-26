package com.example.sports_event_calendar.Repositories;


import com.example.sports_event_calendar.Models.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
