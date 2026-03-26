package com.example.sports_event_calendar.Validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EventDateValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEventDate {
    String message() default "Invalid event date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
