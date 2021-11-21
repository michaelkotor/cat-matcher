package com.example.catmatcherapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
  @Id
  @GeneratedValue
  private Long id;

  private String description;

  private String photoURL;

  private String breedName;

}
