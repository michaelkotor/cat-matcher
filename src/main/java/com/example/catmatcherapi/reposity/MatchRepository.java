package com.example.catmatcherapi.reposity;

import com.example.catmatcherapi.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
