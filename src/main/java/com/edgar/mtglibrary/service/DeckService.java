package com.edgar.mtglibrary.service;

import com.edgar.mtglibrary.model.Card;
import com.edgar.mtglibrary.model.Deck;
import com.edgar.mtglibrary.repository.DeckRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DeckService {
  private final DeckRepository deckRepository;

  public DeckService(DeckRepository deckRepository) {
    this.deckRepository = deckRepository;
  }

  /**
   * Creating a valid commander deck that satisfies all commander deck rules.
   * @param card 100 uniques cards are required.
   * @return a valid commander deck.
   */
  public Deck createCommanderDeck(List<Card> card) {
    return null;
  }

  /**
   * Validating that the deck is a valid commander deck.
   * Some checks are:
   * 1. Deck cannot be null
   * 2. Deck must be a Commander or a Standard deck
   * 3. Commander deck must have 100 UNIQUE cards.
   * 4. All rules for the commander card must be met.
   * @param deck Deck to validate. (Thinking if this should come first before create deck...)
   */
  public void ValidateCommanderDeck(Deck deck) {
    if (deck == null) {
      throw new IllegalArgumentException("Deck cannot be null");
    }
  }

  /**
   * Validating that the deck is a valid standard deck.
   * @param deck
   */
  public void ValidateStandardDeck(Deck deck) {
    if (deck == null) {
      throw new IllegalArgumentException("Deck cannot be null");
    }
  }

  private boolean isLegendary(Card card) {
    if (card.getRarity().equals("Legendary")) {
      return true;
    }
    throw new IllegalArgumentException("Not a Legendary card for a commander decks commander");
  }
}
