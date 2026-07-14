package com.edgar.mtglibrary.service;

import static org.junit.jupiter.api.Assertions.*;

import com.edgar.mtglibrary.model.Card;
import com.edgar.mtglibrary.model.Deck;
import com.edgar.mtglibrary.model.Mana;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckServiceTest {

  private Deck deck;
  private List<Card> cardsNintyNine;
  private List<Card> cards;
  private Card invalidCommanderCard;
  private Card commanderCard;

  @BeforeEach
  void setUp() {
    cardsNintyNine = new ArrayList<>();
    for (int i = 0; i < 99; i++) {
      cardsNintyNine.add(new Card(false, "commander" + i, "name", "rare",
          "type", List.of("ability"), "manaCost",
          "text", List.of(Mana.RED, Mana.BLACK),
          "power", "toughness", 12L + i));
    }

    cards = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      cards.add(new Card(false, "commander" + i, "name", "rare",
          "type", List.of("ability"), "manaCost",
          "text", List.of(Mana.RED, Mana.BLACK),
          "power", "toughness", 14L + i));
    }

    deck = new Deck("My Deck", null, cards,
        "Commander", List.of(Mana.RED, Mana.BLACK), null);

    invalidCommanderCard = new Card(true, "oops?", "name", "Legendary",
        "type", List.of("ability"), "manaCost",
        "text", List.of(Mana.RED, Mana.BLUE),
        "power", "toughness", null);

    commanderCard = new Card(true,"oops?", "name", "Legendary",
        "type", List.of("ability"), "manaCost",
        "text", List.of(Mana.RED, Mana.BLACK),
        "power", "toughness", null);
  }

  @Test
  void testCreateCommanderDeck() {
    // TODO: set-up the database.
  }

  @Test
  void testValidateCommanderDeckUnique() {
    System.out.println(cards.size());
    assertThrows(IllegalArgumentException.class, () -> {
      cardsNintyNine.add(cardsNintyNine.getFirst());
      DeckService invalidUnique = new DeckService(null);
      invalidUnique.validateCommanderDeck(deck, commanderCard);
    });
  }

  @Test
  void testValidateCommanderDeckCommanderColorIdentity() {
    assertThrows(IllegalArgumentException.class, () -> {
      DeckService invalidColorIdentity = new DeckService(null);
      invalidColorIdentity.validateCommanderDeck(deck, invalidCommanderCard);
    });
  }
}