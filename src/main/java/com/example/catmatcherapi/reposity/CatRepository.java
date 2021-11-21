package com.example.catmatcherapi.reposity;

import com.example.catmatcherapi.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
