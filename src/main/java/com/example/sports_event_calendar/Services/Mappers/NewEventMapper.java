package com.example.sports_event_calendar.Services.Mappers;

import com.example.sports_event_calendar.Models.DTOs.NewEventDTO;
import com.example.sports_event_calendar.Models.Entities.Event;
import com.example.sports_event_calendar.Models.Entities.Team;
import com.example.sports_event_calendar.Models.Entities.Venue;
import com.example.sports_event_calendar.Services.TeamService;
import com.example.sports_event_calendar.Services.VenueService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class NewEventMapper {

    private final TeamService teamService;
    private final VenueService venueService;


    public NewEventMapper(TeamService teamService,  VenueService venueService) {
        this.teamService = teamService;
        this.venueService = venueService;
    }

    public Event mapToEvent(NewEventDTO newEventDTO) throws NoSuchElementException {
        Event event = new Event();

        event.setEventDate(newEventDTO.getEventDate());
        event.setEventName(newEventDTO.getEventName());

        Team firstTeam = teamService.findTeamById(newEventDTO.getFirstTeamId());
        Team secondTeam = teamService.findTeamById(newEventDTO.getSecondTeamId());
        Venue venue = venueService.findVenueById(newEventDTO.getVenueId());

        if(firstTeam == null || secondTeam == null || venue == null) {
            throw new NoSuchElementException();
        }

        event.setFirstTeam(firstTeam);
        event.setSecondTeam(secondTeam);
        event.setVenue(venue);

        return event;
    }
}
