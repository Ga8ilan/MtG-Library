package com.edgar.mtglibrary.service;

import com.edgar.mtglibrary.model.Card;
import com.edgar.mtglibrary.model.CommanderDeck;
import com.edgar.mtglibrary.repository.DeckRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Service class for creating and validating decks.
 */
@Service
public class DeckService {
  private final DeckRepository deckRepository;

  public DeckService(DeckRepository deckRepository) {
    this.deckRepository = deckRepository;
  }

  /**
   * Creating a valid commander deck that satisfies all commander deck rules.
   * @param cards 99 uniques cards are required EXCLUDING the commander card.
   * @return a valid commander deck.
   */
  public CommanderDeck createCommanderDeck(List<Card> cards) {
    return null;
  }

  /**
   * Validating that the deck is a valid commander deck.
   * Some checks are:
   * 1. Deck cannot be null
   * 2. Deck must be a Commander or a Standard deck
   * 3. Commander deck must have 100 UNIQUE cards. (99 spell cards + 1 commander card)
   * 4. All rules for the commander card must be met.
   * @param deck Deck to validate.
   */
  public void validateCommanderDeck(CommanderDeck deck, Card commander) {
    if (deck == null) {
      throw new IllegalArgumentException("Deck cannot be null");
    }

    if (!commanderValidManaType(commander, deck.getCards(), deck)) {
      throw new IllegalArgumentException("cards and commander must have the same color identity");
    }

    if (!commanderIsValidSize(deck)) {
      throw new IllegalArgumentException("Deck must have 100 cards including the commander card");
    }

    if (commanderIsDeckUnique(deck.getCards())) {
      throw new IllegalArgumentException("Deck must have 100 unique cards");
    }

  }

  /**
   * Validating that the deck is a valid standard deck.
   * @param deck Deck to validate.
   */
  public void ValidateStandardDeck(CommanderDeck deck) {
    if (deck == null) {
      throw new IllegalArgumentException("Deck cannot be null");
    }
  }

  private boolean commanderValidManaType(Card commander, List<Card> Cards, CommanderDeck deck) {
    for (Card card : Cards) {
      if (!commander.getManaType().equals(card.getManaType()) &&
      (!commander.getManaType().equals(deck.getManaType()))) {
        return false;
      }
    }
    return true;
  }

  private boolean commanderIsValidSize(CommanderDeck deck) {
    return deck.getCards().size() + 1 == 100;
  }

  private boolean commanderIsDeckUnique(List<Card> cards) {
    for (Card card : cards) {
      List<Card> saved;
      saved = new ArrayList<>();
      card = cards.get(cards.indexOf(card) + 1);
      if (cards.contains(card)) {
        // add card to saved cards.
        saved.add(card);
        return !saved.contains(card);
      }
      return true;
    }
    return false;
  }
}
