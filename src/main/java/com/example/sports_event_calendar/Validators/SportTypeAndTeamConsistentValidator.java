package com.example.sports_event_calendar.Validators;

import com.example.sports_event_calendar.Models.DTOs.NewEventDTO;
import com.example.sports_event_calendar.Models.Entities.Team;
import com.example.sports_event_calendar.Repositories.TeamRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class SportTypeAndTeamConsistentValidator implements ConstraintValidator<ValidSportTypeAndTeam, NewEventDTO> {

    private final TeamRepository teamRepository;

    public SportTypeAndTeamConsistentValidator(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void initialize(ValidSportTypeAndTeam constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(NewEventDTO newEventDTO, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Team> firstTeam = teamRepository.findTeamByTeamName(newEventDTO.getFirstTeamName());
        Optional<Team> secondTeam = teamRepository.findTeamByTeamName(newEventDTO.getSecondTeamName());

        if (firstTeam.isEmpty() || secondTeam.isEmpty()) {
            return false;
        }

        if(firstTeam.get().getTeamName().equals(secondTeam.get().getTeamName())) {
            return false;
        }

        final String firstTeamSportType = firstTeam.get().getSportTypeName();
        final String secondTeamSportType = secondTeam.get().getSportTypeName();

        if(!firstTeamSportType.equals(secondTeamSportType) ||
                !firstTeamSportType.equals(newEventDTO.getSportType())) {
            return false;
        }
        return true;
    }
}
