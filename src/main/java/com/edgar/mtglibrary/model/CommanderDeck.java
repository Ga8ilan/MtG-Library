package com.edgar.mtglibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class Deck {
  private String name;
  private String setName;
  @ManyToMany
  private List<Card> cards;
  private String deckType;
  private List<Mana> ColorIdentity;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  public Deck() {}

  public Deck(String name, String setName, List<Card> cards, String deckType, List<Mana> Mana, Long id) {
    this.name = name;
    this.setName = setName;
    this.cards = cards;
    this.deckType = deckType;
    this.id = id;
    this.ColorIdentity = Mana;
  }

  public String getName() {
    return name;
  }

  public String getSetName() {
    return setName;
  }

  public List<Card> getCards() {
    return cards;
  }

  public String getDeckType() {
    return deckType;
  }

  public List<Mana> getColorIdentity() {
    return ColorIdentity;
  }
}
