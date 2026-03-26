package com.example.sports_event_calendar.Services.Mappers;

import com.example.sports_event_calendar.Models.DTOs.EventDTO;
import com.example.sports_event_calendar.Models.Entities.Event;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {


    public EventDTO mapToDTO(Event event){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setEventName(event.getEventName());
        eventDTO.setFirstTeamName(event.getFirstTeamName());
        eventDTO.setSecondTeamName(event.getSecondTeamName());
        eventDTO.setSportType(event.getSportType());

        return eventDTO;
    }
}
