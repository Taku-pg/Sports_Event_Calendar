package com.example.sports_event_calendar.Services.Mappers;

import com.example.sports_event_calendar.Models.DTOs.EventDTO;
import com.example.sports_event_calendar.Models.Entities.Event;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {


    public EventDTO mapToDTO(Event event){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setDayOfWeek(event.getDayOfWeek());
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setFirstTeamName(event.getFirstTeam().getTeamName());
        eventDTO.setSecondTeamName(event.getSecondTeam().getTeamName());
        eventDTO.setSportType(event.getFirstTeam().getSportType().getSportType());
        eventDTO.setVenueName(event.getVenue().getVenueName());

        return eventDTO;
    }
}
