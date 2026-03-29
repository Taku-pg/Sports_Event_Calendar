package com.example.sports_event_calendar.Models.DTOs;

public class VenueDTO {
    private Long id;
    private String venueName;

    public VenueDTO(Long id, String venueName) {
        this.id = id;
        this.venueName = venueName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
}
