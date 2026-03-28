package com.example.sports_event_calendar.Services;

import com.example.sports_event_calendar.Models.DTOs.EventDTO;
import com.example.sports_event_calendar.Models.DTOs.NewEventDTO;
import com.example.sports_event_calendar.Models.Entities.Event;
import com.example.sports_event_calendar.Repositories.EventRepository;
import com.example.sports_event_calendar.Services.Mappers.EventMapper;
import com.example.sports_event_calendar.Services.Mappers.NewEventMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final NewEventMapper newEventMapper;

    public EventService(EventRepository eventRepository,
                        EventMapper eventMapper,
                        NewEventMapper newEventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.newEventMapper = newEventMapper;
    }

    public List<EventDTO> findAll() {
        return eventRepository.findAll()
                                    .stream()
                                    .map(eventMapper::mapToDTO)
                                    .toList();
    }


    public void addNewEvent(NewEventDTO newEventDTO) throws NoSuchElementException {
        Event newEvent = newEventMapper.mapToEvent(newEventDTO);
        eventRepository.save(newEvent);
    }

}
