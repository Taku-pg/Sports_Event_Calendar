package com.example.sports_event_calendar.Services;

import com.example.sports_event_calendar.Models.DTOs.AddressDTO;
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

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    public Venue findVenueById(long id) {
        return venueRepository.findById(id).orElse(null);
    }

    public AddressDTO findAddressById(Venue venue) {
        return venueRepository.getAddress(venue.getId());
    }
}
