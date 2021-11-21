package com.example.catmatcherapi.controller;

import com.example.catmatcherapi.model.Match;
import com.example.catmatcherapi.model.Question;
import com.example.catmatcherapi.model.dto.AnswerDto;
import com.example.catmatcherapi.model.dto.NextQuestionDto;
import com.example.catmatcherapi.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/poll")
public class PollController {

  private final PollService pollService;

  @PostMapping("/start")
  public Question start() {
    return pollService.start();
  }

  @PostMapping("/answer")
  public Question answer(@RequestBody AnswerDto answerDto) {
    return pollService.answer(answerDto);
  }

  @PostMapping("/finish")
  public Match finish() {
    return pollService.finish();
  }
}
