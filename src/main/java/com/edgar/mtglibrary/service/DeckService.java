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
   * @param deck Deck to validate.
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

  private boolean isValidColorIdentity(Card commander, List<Card> Deck) {
    for (Card card : Deck) {
      if (commander.getColorIdentity() != card.getColorIdentity()) {
        return false;
      }
    }
    return true;
  }

  private boolean isValidSize(List<Card> Deck) {
    return Deck.size() == 50;
  }

  private boolean isUnqiue(List<Card> Deck) {
    for (Card card : Deck) {

      List<Card> saved;
      saved = new ArrayList<Card>();

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
