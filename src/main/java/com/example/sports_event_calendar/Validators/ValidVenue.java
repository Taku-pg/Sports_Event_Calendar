package com.example.sports_event_calendar.Validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = VenueValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidVenue {
    String message() default "Venue name is invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
