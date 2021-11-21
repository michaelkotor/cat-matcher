package com.example.catmatcherapi.model;

import com.example.catmatcherapi.model.dto.AnswerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Poll {
  @Id
  @GeneratedValue
  private Long id;

  @ElementCollection
  private Map<Long, Long> choices = new LinkedHashMap<>();

  private Long userId;

  @CreationTimestamp
  private Instant createdAt;

  @UpdateTimestamp
  private Instant updatedAt;

  public void addAnswer(AnswerDto answerDto) {
    choices.put(answerDto.getQuestionId(), answerDto.getAnswerId());
  }

  public Long getLastQuestionId() {
    List<Long> ids = new ArrayList<>(List.copyOf(choices.keySet()));
    Collections.sort(ids);
    if(ids.size() > 0) {
      return ids.get(ids.size() - 1);
    }
    throw new RuntimeException("No choices yet");
  }

  public Map<Long, Long> getChoices() {
    return Collections.unmodifiableMap(choices);
  }
}
