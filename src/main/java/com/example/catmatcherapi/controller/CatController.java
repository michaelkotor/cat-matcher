package com.example.catmatcherapi.controller;

import com.example.catmatcherapi.model.Cat;
import com.example.catmatcherapi.reposity.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cat")
public class CatController {

  private final CatRepository catRepository;

  @GetMapping()
  public List<Cat> cats() {
    return catRepository.findAll();
  }
}
