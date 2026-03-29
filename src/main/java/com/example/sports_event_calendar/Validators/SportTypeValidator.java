package com.example.sports_event_calendar.Validators;

import com.example.sports_event_calendar.Models.DTOs.NewEventDTO;
import com.example.sports_event_calendar.Models.Entities.SportType;
import com.example.sports_event_calendar.Repositories.SportTypeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class SportTypeValidator implements ConstraintValidator<ValidSportType, Long> {

    private final SportTypeRepository sportTypeRepository;

    public SportTypeValidator(SportTypeRepository repository) {
        this.sportTypeRepository = repository;
    }

    @Override
    public void initialize(ValidSportType constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long sportTypeId, ConstraintValidatorContext constraintValidatorContext) {
        return sportTypeRepository.existsById(sportTypeId);
    }
}
