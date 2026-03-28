package com.example.sports_event_calendar.Services.Mappers;

import com.example.sports_event_calendar.Models.DTOs.AddressDTO;
import com.example.sports_event_calendar.Models.DTOs.EventDTO;
import com.example.sports_event_calendar.Models.Entities.Event;
import com.example.sports_event_calendar.Services.VenueService;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {

    private VenueService venueService;

    public EventMapper(VenueService venueService) {
        this.venueService = venueService;
    }


    public EventDTO mapToDTO(Event event){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setEventName(event.getEventName());
        eventDTO.setFirstTeamName(event.getFirstTeamName());
        eventDTO.setSecondTeamName(event.getSecondTeamName());
        eventDTO.setSportType(event.getSportType());
        AddressDTO address = venueService.findAddressById(event.getVenue());
        eventDTO.setAddress(address);

        return eventDTO;
    }

}
