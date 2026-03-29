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
                      e.eventDate,
                      st.sportType,
                      t1.teamName,
                      t2.teamName,
                      v.venueName,
                      v.buildingNumber,
                      s.streetName,
                      ci.cityName,
                      co.countryName
                      )FROM Event e 
                                 JOIN e.firstTeam t1
                                 JOIN e.secondTeam t2
                                 JOIN t1.sportType st
                                 JOIN e.venue v
                                 JOIN v.street s
                                 JOIN s.city ci
                                 JOIN ci.country co 
           """)
    List<EventDTO> findAllEventDTOs();
}
