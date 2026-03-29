package com.example.sports_event_calendar.Services;

import com.example.sports_event_calendar.Models.DTOs.VenueDTO;
import com.example.sports_event_calendar.Models.Entities.Venue;
import com.example.sports_event_calendar.Repositories.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    public final VenueRepository venueRepository;
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<VenueDTO> getAllVenues() {
        return venueRepository.findAllVenue();
    }

    public Venue findVenueById(long id) {
        return venueRepository.findById(id).orElse(null);
    }

}
