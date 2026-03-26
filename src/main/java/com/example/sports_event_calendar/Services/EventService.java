package com.example.sports_event_calendar.Services;

import com.example.sports_event_calendar.Models.DTOs.EventDTO;
import com.example.sports_event_calendar.Repositories.EventRepository;
import com.example.sports_event_calendar.Services.Mappers.EventMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventService(EventRepository eventRepository,  EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public List<EventDTO> findAll() {
        return eventRepository.findAll().stream()
                .map(eventMapper::mapToDTO)
                .sorted(Comparator.comparing(EventDTO::getEventDate))
                .collect(Collectors.toList());
    }

}
