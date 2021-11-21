package com.example.catmatcherapi.config;

import com.example.catmatcherapi.model.Cat;
import com.example.catmatcherapi.model.Option;
import com.example.catmatcherapi.model.Question;
import com.example.catmatcherapi.reposity.CatRepository;
import com.example.catmatcherapi.reposity.OptionRepository;
import com.example.catmatcherapi.reposity.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class InfoPopulation {

  private final CatRepository catRepository;
  private final QuestionRepository questionRepository;
  private final OptionRepository optionRepository;

  @Bean
  public CommandLineRunner addCats() {
    return (args) -> {
      List<Cat> cats = List.of(
              new Cat(1L, "...", "https://cdnn21.img.ria.ru/images/07e5/06/18/1738448523_0:54:864" +
                      ":540_1280x0_80_0_0_b97d299ce7362331302eb511b06c5bba.jpg.webp", "First"),
              new Cat(2L, "...", "https://cdnn21.img.ria.ru/images/07e5/06/18/1738448523_0:54:864" +
                      ":540_1280x0_80_0_0_b97d299ce7362331302eb511b06c5bba.jpg.webp", "Second"),
              new Cat(3L, "...", "https://cdnn21.img.ria.ru/images/07e5/06/18/1738448523_0:54:864" +
                      ":540_1280x0_80_0_0_b97d299ce7362331302eb511b06c5bba.jpg.webp", "Third"),
              new Cat(4L, "...", "https://cdnn21.img.ria.ru/images/07e5/06/18/1738448523_0:54:864" +
                      ":540_1280x0_80_0_0_b97d299ce7362331302eb511b06c5bba.jpg.webp", "Fourth"),
              new Cat(5L, "...", "https://cdnn21.img.ria.ru/images/07e5/06/18/1738448523_0:54:864" +
                      ":540_1280x0_80_0_0_b97d299ce7362331302eb511b06c5bba.jpg.webp", "Fifths")
      );
      log.info("Saving cats...");
      catRepository.saveAll(cats);
    };
  }

  @Bean
  public CommandLineRunner questions() {
    return (args) -> {
      Map<Long, String> options = new HashMap<>();
      options.put(1L, "YES");
      options.put(2L, "NO");
//      log.info("Saving options...");
      List<Question> questions = List.of(
              Question.builder().id(1L).text("First Question").options(options).build(),
              Question.builder().id(2L).text("Second Question").options(options).build(),
              Question.builder().id(3L).text("Third Question").options(options).build(),
              Question.builder().id(4L).text("Fourth Question").options(options).build(),
              Question.builder().id(5L).text("Fifth Question").options(options).build()
      );
      log.info("Saving questions...");
      questionRepository.saveAll(questions);
    };
  }
}
