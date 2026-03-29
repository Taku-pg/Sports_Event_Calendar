package com.example.sports_event_calendar.Validators;

import com.example.sports_event_calendar.Models.Entities.Venue;
import com.example.sports_event_calendar.Repositories.VenueRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class VenueValidator implements ConstraintValidator<ValidVenue, Long> {
    private final VenueRepository venueRepository;
    public VenueValidator(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }
    @Override
    public void initialize(ValidVenue constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long venueId, ConstraintValidatorContext constraintValidatorContext) {
        return venueRepository.existsById(venueId);
    }


}
