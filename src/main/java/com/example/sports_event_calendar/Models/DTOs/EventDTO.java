package com.example.sports_event_calendar.Models.DTOs;


import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class EventDTO {
    private Long id;
    private String eventName;
    private String eventDate;
    private String dayOfWeek;
    private String sportType;
    private String firstTeamName;
    private String secondTeamName;
    private AddressDTO address;
    private String venueName;
    private int buildingNumber;
    private String streetName;
    private String cityName;
    private String countryName;

    public EventDTO(Long id,
                    String eventName,
                    LocalDateTime eventDate,
                    String sportType,
                    String firstTeamName,
                    String secondTeamName,
                    String venueName,
                    int buildingNumber,
                    String streetName,
                    String cityName,
                    String countryName) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        DayOfWeek dow = DayOfWeek.from(eventDate);
        this.dayOfWeek=dow.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        this.sportType = sportType;
        this.firstTeamName = firstTeamName;
        this.secondTeamName = secondTeamName;
        this.venueName = venueName;
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getDayOfWeek(){
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek){
        this.dayOfWeek = dayOfWeek;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getFirstTeamName() {
        return firstTeamName;
    }

    public void setFirstTeamName(String firstTeamName) {
        this.firstTeamName = firstTeamName;
    }

    public String getSecondTeamName() {
        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName) {
        this.secondTeamName = secondTeamName;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
