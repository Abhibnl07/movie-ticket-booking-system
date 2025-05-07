package com.example.movieticketbookingsystem.repository;

import com.example.movieticketbookingsystem.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;

public interface ShowRepository extends JpaRepository<Show, String> {

        @Query("""
        SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END
        FROM Show s
        WHERE s.screen.screenId = :screenId
          AND (
                (:startTime < s.endsAt AND :endTime > s.startsAt)
              )
    """)
        boolean existsOverlappingShow(@Param("screenId") String screenId,
                                      @Param("startTime") Instant startAt,
                                      @Param("endTime") Instant endAt);
    }

