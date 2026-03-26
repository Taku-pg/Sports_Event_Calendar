package com.example.sports_event_calendar.Controllers;

import com.example.sports_event_calendar.Models.DTOs.EventDTO;
import com.example.sports_event_calendar.Models.DTOs.EventDetailDTO;
import com.example.sports_event_calendar.Models.Entities.Event;
import com.example.sports_event_calendar.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public String sportsEvents(Model model) {
        List<EventDTO> events = eventService.findAll();
        model.addAttribute("events", events);
        return "events";
    }

    @GetMapping("/events")
    public String eventDetails(Model model, @RequestParam(name = "eventId") Long eventId) {
        EventDetailDTO eventDetailDTO = eventService.findEventDetailById(eventId);
        model.addAttribute("eventDetailDTO", eventDetailDTO);
        return "event_detail";
    }
}
