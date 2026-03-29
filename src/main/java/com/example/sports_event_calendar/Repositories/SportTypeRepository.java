package com.example.sports_event_calendar.Repositories;

import com.example.sports_event_calendar.Models.DTOs.SportTypeDTO;
import com.example.sports_event_calendar.Models.Entities.SportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SportTypeRepository extends JpaRepository<SportType, Long> {

    @Query("SELECT new com.example.sports_event_calendar.Models.DTOs.SportTypeDTO( st.id, st.sportType) FROM SportType st")
    List<SportTypeDTO> findAllDTO();

    @Query("SELECT st.sportType FROM SportType st WHERE st.id = :id")
    String findSportTypeName(@Param("id") Long id);

}
