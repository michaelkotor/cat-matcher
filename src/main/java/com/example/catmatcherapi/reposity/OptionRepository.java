package com.example.catmatcherapi.reposity;

import com.example.catmatcherapi.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
