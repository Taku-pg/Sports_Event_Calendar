package com.example.sports_event_calendar.Services;

import com.example.sports_event_calendar.Models.DTOs.AddressDTO;
import com.example.sports_event_calendar.Models.DTOs.EventDTO;
import com.example.sports_event_calendar.Models.DTOs.EventDetailDTO;
import com.example.sports_event_calendar.Models.DTOs.NewEventDTO;
import com.example.sports_event_calendar.Models.Entities.Event;
import com.example.sports_event_calendar.Repositories.EventRepository;
import com.example.sports_event_calendar.Repositories.VenueRepository;
import com.example.sports_event_calendar.Services.Mappers.EventDetailMapper;
import com.example.sports_event_calendar.Services.Mappers.EventMapper;
import com.example.sports_event_calendar.Services.Mappers.NewEventMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class EventService {
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final EventMapper eventMapper;
    private final EventDetailMapper eventDetailMapper;
    private final NewEventMapper newEventMapper;

    public EventService(EventRepository eventRepository,
                        VenueRepository venueRepository,
                        EventMapper eventMapper,
                        EventDetailMapper eventDetailMapper,
                        NewEventMapper newEventMapper) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
        this.eventMapper = eventMapper;
        this.eventDetailMapper = eventDetailMapper;
        this.newEventMapper = newEventMapper;
    }

    public List<EventDTO> findAll() {
        return eventRepository.findAllEvents();
    }

    public EventDetailDTO findEventDetailById(Long id) {
        Event event = eventRepository.findById(id).orElseThrow();
        AddressDTO addressDTO = venueRepository.getAddress(event.getVenue().getId());
        return eventDetailMapper.mapToEventDetail(event,addressDTO);
    }

    public void addNewEvent(NewEventDTO newEventDTO) throws NoSuchElementException {
        Event newEvent = newEventMapper.mapToEvent(newEventDTO);
        eventRepository.save(newEvent);
    }

}
