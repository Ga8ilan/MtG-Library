package com.edgar.mtglibrary.service;

import com.edgar.mtglibrary.model.Card;
import com.edgar.mtglibrary.model.Deck;
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
   * @param cards 100 uniques cards are required.
   * @return a valid commander deck.
   */
  public Deck createCommanderDeck(List<Card> cards) {
    return null;
  }

  /**
   * Validating that the deck is a valid commander deck.
   * Some checks are:
   * 1. Deck cannot be null
   * 2. Deck must be a Commander or a Standard deck
   * 3. Commander deck must have 100 UNIQUE cards.
   * 4. All rules for the commander card must be met.
   * @param deck Deck to validate. (Thinking if this should come first before creating deck...)
   */
  public void ValidateCommanderDeck(Deck deck, Card commander) {
    if (deck == null) {
      throw new IllegalArgumentException("Deck cannot be null");
    }

    if (commanderIsValidColorIdentity(commander, deck.getCards())) {
      throw new IllegalArgumentException("Deck and commander must have the same color identity");
    }

    if (!commanderIsValidSize(deck.getCards())) {
      throw new IllegalArgumentException("Deck must have 100 cards");
    }

    if (commanderIsDeckUnique(deck.getCards())) {
      throw new IllegalArgumentException("Deck must have 100 unique cards");
    }

  }

  /**
   * Validating that the deck is a valid standard deck.
   * @param deck Deck to validate.
   */
  public void ValidateStandardDeck(Deck deck) {
    if (deck == null) {
      throw new IllegalArgumentException("Deck cannot be null");
    }
  }

  private boolean commanderIsValidColorIdentity(Card commander, List<Card> Cards) {
    for (Card card : Cards) {
      if (!commander.getColorIdentity().equals(card.getColorIdentity())) {
        return false;
      }
    }
    return true;
  }

  private boolean commanderIsValidSize(List<Card> Deck) {
    return Deck.size() == 100;
  }

  private boolean commanderIsDeckUnique(List<Card> Deck) {
    for (Card card : Deck) {
      List<Card> saved;
      saved = new ArrayList<>();
      card = Deck.get(Deck.indexOf(card) + 1);
      if (Deck.contains(card)) {
        // add card to saved cards.
        saved.add(card);
        return !saved.contains(card);
      }
      return true;
    }
    return false;
  }
}
