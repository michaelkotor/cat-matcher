package com.example.catmatcherapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Option {

  @Id
  private Long id;

  private String content;

  @ManyToOne
  private Question question;

  public Option(Long id, String content) {
    this.id = id;
    this.content = content;
  }
}
