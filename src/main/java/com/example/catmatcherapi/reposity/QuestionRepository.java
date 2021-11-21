package com.example.catmatcherapi.reposity;

import com.example.catmatcherapi.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
