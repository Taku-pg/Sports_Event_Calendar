package com.example.sports_event_calendar.Validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SportTypeAndTeamConsistentValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSportTypeAndTeam {
    String message() default "Sport type or team is invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
