package com.example.sports_event_calendar.Repositories;


import com.example.sports_event_calendar.Models.DTOs.EventDTO;
import com.example.sports_event_calendar.Models.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("""
            SELECT new com.example.sports_event_calendar.Models.DTOs.EventDTO(
                        e.id, 
                        e.eventName, 
                        t1.teamName, 
                        t2.teamName, 
                        st.sportType
            ) 
            FROM Event e
            JOIN e.firstTeam t1
            JOIN e.secondTeam t2
            JOIN t1.sportType st 
            ORDER BY e.eventDate 
            """)
    public List<EventDTO> findAllEvents();
}
