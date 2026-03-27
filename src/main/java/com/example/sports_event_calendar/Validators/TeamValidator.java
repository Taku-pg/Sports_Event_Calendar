package com.example.sports_event_calendar.Validators;

import com.example.sports_event_calendar.Models.Entities.Team;
import com.example.sports_event_calendar.Repositories.TeamRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class TeamValidator implements ConstraintValidator<ValidTeam, Long> {

    private final TeamRepository teamRepository;

    public TeamValidator(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void initialize(ValidTeam constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long teamId, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Team> team = teamRepository.findTeamById(teamId);
        return team.isPresent();
    }

}
