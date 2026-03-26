package com.example.sports_event_calendar.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class EventDateValidator implements ConstraintValidator<ValidEventDate, LocalDateTime> {
    @Override
    public void initialize(ValidEventDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDateTime localDateTime, ConstraintValidatorContext constraintValidatorContext) {
        if(localDateTime == null){
            return false;
        }
        return !LocalDateTime.now().isAfter(localDateTime);
    }


}
