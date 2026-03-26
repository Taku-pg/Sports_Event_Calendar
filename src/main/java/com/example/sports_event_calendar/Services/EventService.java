package com.example.sports_event_calendar.Services;

import com.example.sports_event_calendar.Models.DTOs.AddressDTO;
import com.example.sports_event_calendar.Models.DTOs.EventDTO;
import com.example.sports_event_calendar.Models.DTOs.EventDetailDTO;
import com.example.sports_event_calendar.Models.Entities.Event;
import com.example.sports_event_calendar.Repositories.EventRepository;
import com.example.sports_event_calendar.Repositories.VenueRepository;
import com.example.sports_event_calendar.Services.Mappers.EventDetailMapper;
import com.example.sports_event_calendar.Services.Mappers.EventMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EventService {
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final EventMapper eventMapper;
    private final EventDetailMapper eventDetailMapper;

    public EventService(EventRepository eventRepository,
                        VenueRepository venueRepository,
                        EventMapper eventMapper,
                        EventDetailMapper eventDetailMapper) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
        this.eventMapper = eventMapper;
        this.eventDetailMapper = eventDetailMapper;
    }

    public List<EventDTO> findAll() {
        return eventRepository.findAll().stream()
                .map(eventMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public EventDetailDTO findEventDetailById(Long id) {
        Event event = eventRepository.findById(id).orElseThrow();
        AddressDTO addressDTO = venueRepository.getAddress(event.getVenue().getId());
        return eventDetailMapper.mapToEventDetail(event,addressDTO);
    }

}
