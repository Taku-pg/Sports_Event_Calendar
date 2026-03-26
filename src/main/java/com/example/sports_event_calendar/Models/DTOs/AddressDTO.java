package com.example.sports_event_calendar.Models.DTOs;

public class AddressDTO {
    private String venueName;
    private int buildingNumber;
    private String streetName;
    private String cityName;
    private String countryName;

    public AddressDTO(String venueName,
                      int buildingNumber,
                      String streetName,
                      String cityName,
                      String countryName
                      ) {
        this.venueName = venueName;
        this.countryName = countryName;
        this.cityName = cityName;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
    }

    public String getVenueName() {
        return venueName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }
}
