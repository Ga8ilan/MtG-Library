package com.edgar.mtglibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;
import java.util.Set;

@Entity
public class CommanderDeck {
  private String name;
  private String setName; // optional
  @ElementCollection
  private Set<Mana> manaType;
  @ManyToOne
  private Card commanderCard;
  @ManyToMany
  private List<Card> cards;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  public CommanderDeck() {}

  public CommanderDeck(String name, String setName, Set<Mana> manaType, Card commanderCard, List<Card> cards, Long id) {
    this.name = name;
    this.setName = setName;
    this.manaType = manaType;
    this.commanderCard = commanderCard;
    this.cards = cards;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getSetName() {
    return setName;
  }

  @Enumerated(EnumType.STRING)
  public Set<Mana> getManaType() {
    return manaType;
  }

  public Card getCommanderCard() {
    return commanderCard;
  }

  public List<Card> getCards() {
    return cards;
  }
}
