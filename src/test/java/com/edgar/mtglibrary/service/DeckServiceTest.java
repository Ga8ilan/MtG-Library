package com.edgar.mtglibrary.service;

import static org.junit.jupiter.api.Assertions.*;

import com.edgar.mtglibrary.model.Card;
import com.edgar.mtglibrary.model.CommanderDeck;
import com.edgar.mtglibrary.model.Mana;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckServiceTest {

  private CommanderDeck commanderDeck;
  private CommanderDeck invalidCommanderDeck;
  private List<Card> cardsNintyNine; // A STANDARD DECK WOULD HAVE A LIST OF 99 CARDS.
  private List<Card> cards;
  private Card invalidCommanderCard;
  private Card commanderCard;
  private Card randomCard;

  @BeforeEach
  void setUp() {
    cardsNintyNine = new ArrayList<>();
    for (int i = 0; i < 99; i++) {
      cardsNintyNine.add(new Card(false, "commander" + i, "name", "rare",
          "type", List.of("ability"), List.of(Mana.RED, Mana.BLACK, Mana.BLACK),
          "text", List.of(Mana.RED, Mana.BLACK),
          "power", "toughness", 12L + i));
    }

    cards = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      cards.add(new Card(false, "commander" + i, "name", "rare",
          "type", List.of("ability"), List.of(Mana.RED, Mana.BLACK, Mana.BLACK),
          "text", List.of(Mana.RED, Mana.BLACK),
          "power", "toughness", 14L + i));
    }

    invalidCommanderCard = new Card(true, "oops?", "name", "Legendary",
        "type", List.of("ability"), List.of(Mana.RED, Mana.BLACK, Mana.BLACK),
        "text", List.of(Mana.RED, Mana.BLUE),
        "power", "toughness", null);

    commanderCard = new Card(true,"oops?", "name", "Legendary",
        "type", List.of("ability"), List.of(Mana.RED, Mana.BLACK, Mana.BLACK),
        "text", List.of(Mana.RED, Mana.BLACK),
        "power", "toughness", null);

    randomCard = new Card(false,"oops?", "name", "Legendary",
        "type", List.of("ability"), List.of(Mana.RED, Mana.BLACK, Mana.BLACK),
        "text", List.of(Mana.RED, Mana.BLACK),
        "power", "toughness", null);

    invalidCommanderDeck = new CommanderDeck("My Deck", null, List.of(Mana.RED, Mana.BLACK),
        commanderCard, cards, null);

    commanderDeck = new CommanderDeck("My Deck", null, List.of(Mana.RED, Mana.BLACK),
        commanderCard, cardsNintyNine, null);

  }

  @Test
  void testCreateCommanderDeck() {
    // TODO: set-up the database.
  }

  @Test
  void testValidateCommanderDeckUnique() {
    assertThrows(IllegalArgumentException.class, () -> {
      cardsNintyNine.add(cardsNintyNine.getFirst());
      DeckService invalidUnique = new DeckService(null);
      invalidUnique.validateCommanderDeck(commanderDeck, commanderCard);
    });
  }

  @Test
  void testValidateCommanderDeckCommanderColorIdentity() {
    assertThrows(IllegalArgumentException.class, () -> {
      DeckService invalidColorIdentity = new DeckService(null);
      invalidColorIdentity.validateCommanderDeck(commanderDeck, invalidCommanderCard);
    });
  }

  @Test
  void testIsValidSizeCommanderDeck() {
    cards.add(randomCard);
    assertThrows(IllegalArgumentException.class, () -> {
      DeckService invalidSize = new DeckService(null);
      invalidSize.validateCommanderDeck(invalidCommanderDeck, commanderCard);
    });
  }
}