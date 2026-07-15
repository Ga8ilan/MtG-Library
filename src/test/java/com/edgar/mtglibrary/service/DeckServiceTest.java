package com.edgar.mtglibrary.service;

import static org.junit.jupiter.api.Assertions.*;

import com.edgar.mtglibrary.model.Card;
import com.edgar.mtglibrary.model.Mana;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckServiceTest {

  private List<Card> cards; // A STANDARD DECK WOULD HAVE A LIST OF 99 CARDS.
  private List<Card> invalidCards;
  private List<Card> invalidCardsOneThousand;
  private List<Card> nullCards;
  private Card invalidCommanderCard;
  private Card commanderCard;
  private Card randomCard;
  private Card nullCard;
  // private CommanderDeck nullDeck;

  @BeforeEach
  void setUp() {
    cards = new ArrayList<>();
    for (int i = 0; i < 99; i++) {
      cards.add(new Card(false, "commander" + i, "name", "rare",
          "type", List.of("ability"), List.of(Mana.RED, Mana.BLACK, Mana.BLACK),
          "text", Set.of(Mana.RED, Mana.BLACK),
          "power", "toughness", 12L + i));
    }

    invalidCards = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      invalidCards.add(new Card(false, "commander" + i, "name", "rare",
          "type", List.of("ability"), List.of(Mana.RED, Mana.BLACK, Mana.BLACK),
          "text", Set.of(Mana.RED, Mana.BLACK),
          "power", "toughness", 14L + i));
    }

    invalidCardsOneThousand = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      invalidCardsOneThousand.add(new Card(false, "commander" + i, "name", "rare",
          "type", List.of("ability"), List.of(Mana.RED, Mana.BLACK, Mana.BLACK),
          "text", Set.of(Mana.RED, Mana.BLACK),
          "power", "toughness", 14L + i));
    }

    nullCards = new ArrayList<>();
    for (int i = 0; i < 99; i++) {
      nullCards.add(nullCard);
    }

    invalidCommanderCard = new Card(true, "oops?", "name", "Legendary",
        "type", List.of("ability"), List.of(Mana.RED, Mana.BLACK, Mana.BLACK),
        "text", Set.of(Mana.RED, Mana.BLUE),
        "power", "toughness", null);

    commanderCard = new Card(true,"oops?", "name", "Legendary",
        "type", List.of("ability"), List.of(Mana.RED, Mana.BLACK, Mana.BLACK),
        "text", Set.of(Mana.RED, Mana.BLACK),
        "power", "toughness", null);

    randomCard = new Card(false,"oops?", "name", "Legendary",
        "type", List.of("ability"), List.of(Mana.RED, Mana.BLACK, Mana.BLACK),
        "text", Set.of(Mana.RED, Mana.BLACK),
        "power", "toughness", null);

    nullCard = new Card(null, null, null, null, null,
        null, null, null, null, null, null, null);

    // nullDeck = new CommanderDeck(null, null, null, null, null, null);
  }

  @Test
  void testCreateCommanderDeck() {
    // TODO: set-up the database.
  }

  @Test
  void testValidateCommanderDeckNull() {
    assertThrows(NullPointerException.class, () -> {
      DeckService invalidNull = new DeckService(null);
      invalidNull.validateCommanderCards(nullCards, commanderCard);
    });
  }

  @Test
  void testValidateCommanderDeckNotNull() {
    assertDoesNotThrow(() -> {
      DeckService invalidNull = new DeckService(null);
      invalidNull.validateCommanderCards(cards, commanderCard);
    });
  }

  @Test
  void testValidateCommanderDeckUnique() {
    assertThrows(IllegalArgumentException.class, () -> {
      cards.add(cards.getFirst());
      DeckService invalidUnique = new DeckService(null);
      invalidUnique.validateCommanderCards(cards, commanderCard);
    });
  }

  @Test
  void testValidateCommanderDeckNotUnique() {
    assertDoesNotThrow(() -> {
      DeckService invalidUnique = new DeckService(null);
      invalidUnique.validateCommanderCards(cards, commanderCard);
    });
  }

  @Test
  void testValidateCommanderDeckCommanderColorIdentity() {
    assertThrows(IllegalArgumentException.class, () -> {
      DeckService invalidColorIdentity = new DeckService(null);
      invalidColorIdentity.validateCommanderCards(cards, invalidCommanderCard);
    });
  }

  @Test
  void testAreCardsValidSizePlus() {
    cards.add(randomCard);
    assertThrows(IllegalArgumentException.class, () -> {
      DeckService invalidSize = new DeckService(null);
      invalidSize.validateCommanderCards(cards, commanderCard);
    });
  }

  @Test
  void testAreCardsValidSizeMinus() {
    cards.remove(cards.getFirst());
    assertThrows(IllegalArgumentException.class, () -> {
      DeckService invalidSize = new DeckService(null);
      invalidSize.validateCommanderCards(cards, commanderCard);
    });
  }

  @Test
  void testAreCardsValidSizeCheck() {
    assertDoesNotThrow(() -> {
      DeckService invalidSize = new DeckService(null);
      invalidSize.validateCommanderCards(cards, commanderCard);
    });
  }

  @Test
  void testAreCardsinValidSizeCheckOneThousand() {
    assertThrows(IllegalArgumentException.class, () -> {
      DeckService invalidSize = new DeckService(null);
      invalidSize.validateCommanderCards(invalidCardsOneThousand, commanderCard);
    });
  }
}