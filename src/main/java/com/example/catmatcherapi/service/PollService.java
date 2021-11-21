package com.example.catmatcherapi.service;

import com.example.catmatcherapi.model.Cat;
import com.example.catmatcherapi.model.Match;
import com.example.catmatcherapi.model.Poll;
import com.example.catmatcherapi.model.Question;
import com.example.catmatcherapi.model.User;
import com.example.catmatcherapi.model.dto.AnswerDto;
import com.example.catmatcherapi.model.dto.NextQuestionDto;
import com.example.catmatcherapi.reposity.CatRepository;
import com.example.catmatcherapi.reposity.MatchRepository;
import com.example.catmatcherapi.reposity.PollRepository;
import com.example.catmatcherapi.reposity.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PollService {

  private final UserService userService;
  private final QuestionRepository questionRepository;
  private final PollRepository pollRepository;
  private final CatRepository catRepository;
  private final MatchRepository matchRepository;

  @Transactional
  public Question start() {
    Poll poll = new Poll();
    poll.setUserId(userService.getCurrentUser().getId());
    pollRepository.save(poll);
    return questionRepository.findById(1L).orElseThrow();
  }

  @Transactional
  public Question answer(AnswerDto answerDto) {
    User currentUser = userService.getCurrentUser();
    Pageable p = PageRequest.of(0, 100, Sort.Direction.DESC, "updatedAt");
    Poll currentPoll = pollRepository.findByUserId(currentUser.getId(), p).get(0);
    currentPoll.addAnswer(answerDto);
    pollRepository.save(currentPoll);
    Question empty = new Question();
    empty.setId(-1L);
    Optional<Question> nextQuestion = questionRepository.findById(answerDto.getQuestionId() + 1);
    return nextQuestion.orElse(empty);
  }

  @Transactional
  public Match finish() {
    User currentUser = userService.getCurrentUser();
    Pageable p = PageRequest.of(0, 100, Sort.Direction.DESC, "updatedAt");
    Poll lastPoll = pollRepository.findByUserId(currentUser.getId(), p).get(0);
    Long lastQuestionId = lastPoll.getLastQuestionId();
    Optional<Question> nextQuestion = questionRepository.findById(lastQuestionId + 1);
    if(nextQuestion.isPresent()) {
      throw new RuntimeException("There more questions");
    }

    Match match = new Match();
    Cat randomCat = new Cat();
    randomCat.setDescription("A crazy one");
    randomCat.setPhotoURL("https://cdnn21.img.ria.ru/images/07e5/06/18/1738448523_0:54:864:540_1280x0_80_0_0_b97d299ce7362331302eb511b06c5bba.jpg.webp");
    randomCat.setBreedName("Unknown");
    catRepository.save(randomCat);
    match.setCat(randomCat);
    return matchRepository.save(match);
  }
}
