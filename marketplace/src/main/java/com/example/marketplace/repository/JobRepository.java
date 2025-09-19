package com.example.marketplace.repository;


import com.example.marketplace.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.time.LocalDateTime;

public interface JobRepository extends JpaRepository<Job, Long> {

    // Recent jobs (no change)
    List<Job> findTop10ByOrderByCreatedAtDesc();

    // Top 10 active jobs by number of bids — only future or null expiration
    @Query("""
        SELECT j
        FROM Job j
        LEFT JOIN j.bids b
        WHERE j.expiresAt IS NULL OR j.expiresAt > :now
        GROUP BY j.id
        ORDER BY COUNT(b) DESC
        """)
    List<Job> findTop10ActiveByMostBids(@Param("now") LocalDateTime now);

    @Query("SELECT j FROM Job j WHERE j.expiresAt <= :now AND j.winnerBid IS NULL")
    List<Job> findExpiredWithoutWinner(@Param("now") LocalDateTime now);
}
