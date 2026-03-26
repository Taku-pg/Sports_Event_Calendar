package com.example.sports_event_calendar.Services.Mappers;

import com.example.sports_event_calendar.Models.DTOs.AddressDTO;
import com.example.sports_event_calendar.Models.DTOs.EventDetailDTO;
import com.example.sports_event_calendar.Models.Entities.Event;
import org.springframework.stereotype.Service;

@Service
public class EventDetailMapper {

    public EventDetailDTO mapToEventDetail(Event event, AddressDTO addressDTO) {
        EventDetailDTO eventDetailDTO = new EventDetailDTO();

        eventDetailDTO.setEventDate(event.getEventDate());
        eventDetailDTO.setDayOfWeek(event.getDayOfWeek());
        eventDetailDTO.setFirstTeamName(event.getFirstTeamName());
        eventDetailDTO.setSecondTeamName(event.getSecondTeamName());
        eventDetailDTO.setSportType(event.getSportType());
        eventDetailDTO.setAddress(addressDTO);

        return  eventDetailDTO;
    }
}
