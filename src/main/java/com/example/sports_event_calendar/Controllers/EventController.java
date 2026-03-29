package com.example.sports_event_calendar.Controllers;

import com.example.sports_event_calendar.Models.DTOs.EventDTO;
import com.example.sports_event_calendar.Models.DTOs.NewEventDTO;
import com.example.sports_event_calendar.Models.DTOs.SportTypeDTO;
import com.example.sports_event_calendar.Models.DTOs.VenueDTO;
import com.example.sports_event_calendar.Models.Entities.Venue;
import com.example.sports_event_calendar.Services.EventService;
import com.example.sports_event_calendar.Services.SportTypeService;
import com.example.sports_event_calendar.Services.VenueService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class EventController {

    private final EventService eventService;
    private final SportTypeService  sportTypeService;
    private final VenueService venueService;

    public EventController(EventService eventService,
                           SportTypeService sportTypeService,
                           VenueService venueService) {
        this.eventService = eventService;
        this.sportTypeService = sportTypeService;
        this.venueService = venueService;
    }

    @GetMapping
    public String sportsEvents(Model model) {
        List<EventDTO> events = eventService.findAll();
        model.addAttribute("events", events);
        return "events";
    }


    @GetMapping("/add-event")
    public String addEvent(Model model, @ModelAttribute NewEventDTO newEventDTO) {
        List<SportTypeDTO> allSportTypes = sportTypeService.getAllSportTypes();
        List<VenueDTO> allVenues = venueService.getAllVenues();

        model.addAttribute("newEvent", newEventDTO);
        model.addAttribute("allSportTypes", allSportTypes);
        model.addAttribute("allVenues", allVenues);
        model.addAttribute("minDate", LocalDateTime.now().plusDays(1));
        return "add_event";
    }

    @PostMapping("/add-event")
    public String addEvent(@Valid @ModelAttribute(name = "newEvent") NewEventDTO newEventDTO,
                           BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            List<SportTypeDTO> allSportTypes = sportTypeService.getAllSportTypes();
            List<VenueDTO> allVenues = venueService.getAllVenues();

            model.addAttribute("allSportTypes", allSportTypes);
            model.addAttribute("allVenues", allVenues);
            model.addAttribute("minDate", LocalDateTime.now().plusDays(1));

            return "add_event";
        }

        try{
            eventService.addNewEvent(newEventDTO);
        }catch(NoSuchElementException e){
            model.addAttribute("errorMessage", "Invalid input value, try again");

            List<SportTypeDTO> allSportTypes = sportTypeService.getAllSportTypes();
            List<VenueDTO> allVenues = venueService.getAllVenues();

            model.addAttribute("allSportTypes", allSportTypes);
            model.addAttribute("allVenues", allVenues);
            model.addAttribute("minDate", LocalDateTime.now().plusDays(1));
            model.addAttribute("errorMessage", "Invalid input value, try again");

            return "add_event";
        }
        return "redirect:/";
    }
}
