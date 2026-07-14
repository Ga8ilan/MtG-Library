package com.edgar.mtglibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Card {
  private Boolean isCommander;
  private String card;
  private String name;
  // Legendary, Common, Uncommon, Rare, Mythic - That stuff
  private String rarity;
  // Creature, Artifact, Enchantment, Planeswalker, Sorcery, Instant, Sorcery, Land
  private String type;
  // Flying, Trample, Death touch, LifeLink, Double strike
  List<String> abilities;
  List<Mana> manaCost;
  private String text;
  @ElementCollection
  List<Mana> manaType;
  private String power;
  private String toughness;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  // Constructor for JPA
  public Card() {}

  // Constructor for the class
  public Card(Boolean isCommander, String card, String name, String rarity, String type, List<String> abilities, List<Mana> manaCost,
              String text, List<Mana> manaType, String power, String toughness, Long id) {

    this.isCommander = isCommander;
    this.card = card;
    this.name = name;
    this.rarity = rarity;
    this.type = type;
    this.abilities = abilities;
    this.manaCost = manaCost;
    this.text = text;
    this.manaType = manaType;
    this.power = power;
    this.toughness = toughness;
    this.id = id;
  }

  public Boolean getIsCommander() {
    return isCommander;
  }

  public String getCard() {
    return card;

  }
  public String getName() {
    return name;
  }

  public String getRarity() {
    return rarity;
  }

  public String getType() {
    return type;
  }

  public List<String> getAbilities() {
    return abilities;
  }

  public List<Mana> getManaCost() {
    return manaCost;
  }

  public String getText() {
    return text;
  }

  @Enumerated(EnumType.STRING)
  public List<Mana> getManaType() {
    return manaType;
  }

  public String getPower() {
    return power;
  }

  public String getToughness() {
    return toughness;
  }
}






