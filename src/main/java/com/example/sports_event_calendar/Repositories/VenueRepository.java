package com.example.sports_event_calendar.Repositories;

import com.example.sports_event_calendar.Models.DTOs.AddressDTO;
import com.example.sports_event_calendar.Models.DTOs.VenueDTO;
import com.example.sports_event_calendar.Models.Entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VenueRepository extends JpaRepository<Venue,Long> {

    @Query("""
           SELECT new com.example.sports_event_calendar.Models.DTOs.VenueDTO(
                      v.id,
                      v.venueName
                      )FROM Venue v
           """)
    List<VenueDTO> findAllVenue();
}
