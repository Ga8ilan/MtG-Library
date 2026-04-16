package com.edgar.mtglibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Card {
  private String name;
  // Legendary, Common, Uncommon, Rare, Mythic - That stuff
  private String rarity;
  // Creature, Artifact, Enchantment, Planeswalker, Sorcery, Instant, Sorcery, Land
  private String type;
  // Flying, Trample, Death touch, LifeLink, Double strike
  List<String> abilities;
  private String manaCost;
  private String text;
  List<String> colorIdentity;
  private String power;
  private String toughness;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;
}


