package com.edgar.mtglibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;

@Entity
public class Deck {
  private String name;
  private String set;
  @ManyToMany
  private List<Card> cards;
  private String deckType;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

}
