package com.example.sports_event_calendar.Repositories;

import com.example.sports_event_calendar.Models.Entities.SportType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SportTypeRepository extends JpaRepository<SportType, Long> {
    Optional<SportType> findSportTypeBySportType(String sportType);

    Optional<SportType> findSportTypeById(Long id);
}
