package com.example.sports_event_calendar.Repositories;

import com.example.sports_event_calendar.Models.DTOs.AddressDTO;
import com.example.sports_event_calendar.Models.Entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VenueRepository extends JpaRepository<Venue,Long> {

    @Query("""
    SELECT new com.example.sports_event_calendar.Models.DTOs.AddressDTO(
         v.venueName, 
         v.buildingNumber, 
         s.streetName,
         ci.cityName, 
         co.countryName
             )
        FROM Venue v 
            JOIN v.street s
            JOIN s.city ci
            JOIN ci.country co 
                WHERE v.id = :venueId
    """)
    public AddressDTO getAddress(@Param("venueId")  Long venueId);

    Optional<Venue> findVenueByVenueName(String venueName);
}
