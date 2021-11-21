package com.example.catmatcherapi.reposity;

import com.example.catmatcherapi.model.Poll;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PollRepository extends JpaRepository<Poll, Long> {
  List<Poll> findByUserId(Long id, Pageable pageable);

}
