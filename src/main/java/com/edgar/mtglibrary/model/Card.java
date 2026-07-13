package com.edgar.mtglibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Card {
  private String commanderCard;
  private String name;
  // Legendary, Common, Uncommon, Rare, Mythic - That stuff
  private String rarity;
  // Creature, Artifact, Enchantment, Planeswalker, Sorcery, Instant, Sorcery, Land
  private String type;
  // Flying, Trample, Death touch, LifeLink, Double strike
  List<String> abilities;
  private String manaCost;
  private String text;
  List<Mana> colorIdentity;
  private String power;
  private String toughness;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  // Constructor for JPA
  public Card() {}

  // Constructor for the class
  public Card(String commanderCard, String name, String rarity, String type, List<String> abilities, String manaCost,
              String text, List<Mana> colorIdentity, String power, String toughness, Long id) {

    this.commanderCard = commanderCard;
    this.name = name;
    this.rarity = rarity;
    this.type = type;
    this.abilities = abilities;
    this.manaCost = manaCost;
    this.text = text;
    this.colorIdentity = colorIdentity;
    this.power = power;
    this.toughness = toughness;
    this.id = id;
  }

  public String getCommanderCard() {
    return commanderCard;

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

  public String getManaCost() {
    return manaCost;
  }

  public String getText() {
    return text;
  }

  public List<Mana> getColorIdentity() {
    return colorIdentity;
  }

  public String getPower() {
    return power;
  }

  public String getToughness() {
    return toughness;
  }
}






