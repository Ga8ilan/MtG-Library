package com.edgar.mtglibrary.service;

import com.edgar.mtglibrary.model.Card;
import com.edgar.mtglibrary.model.CommanderDeck;
import com.edgar.mtglibrary.repository.DeckRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
  public CommanderDeck createCommanderDeck(List<Card> cards, Card commanderCard, String name) {
    validateCommanderCards(cards, commanderCard);
    // TODO: create database in order to fill in code skeleton
    return new CommanderDeck();
  }

  /**
   * Validating that the deck is a valid commander deck.
   * Some checks are:
   * 1. Deck cannot be null
   * 2. Deck must be a Commander or a Standard deck
   * 3. Commander deck must have 100 UNIQUE cards. (99 spell cards + 1 commander card)
   * 4. All rules for the commander card must be met.
   * @param cards cards to be validated.
   * @param commander commander to be validated with cards.
   */
  public void validateCommanderCards(List<Card> cards, Card commander) {
    if (cards == null) {
      throw new NullPointerException("list of cards cannot be null");
    }

    if (!commanderValidManaType(commander, cards)) {
      throw new IllegalArgumentException("cards and commander must have the same color identity");
    }

    if (!commanderIsValidSize(cards)) {
      throw new IllegalArgumentException("Deck must have 100 cards including the commander card");
    }

    if (!commanderAreCardsUnique(cards)) {
      throw new IllegalArgumentException("Deck must have 100 unique cards");
    }
  }

  private boolean commanderValidManaType(Card commander, List<Card> Cards) {
    for (Card card : Cards) {
      if (!commander.getManaType().containsAll(card.getManaType())) {
        return false;
      }
    }
    return true;
  }

  private boolean commanderIsValidSize(List<Card> cards ) {
    return cards.size() + 1 == 100;
  }

  private boolean commanderAreCardsUnique(List<Card> cards) {
    Set<Card> savedCards = new HashSet<Card>();
    for (Card card : cards) {
      card = cards.get(cards.indexOf(card) + 1);
      if (cards.contains(card)) {
        // add card to saved cards.
        savedCards.add(card);
        return !savedCards.contains(card);
      }
      return false;
    }
    return true;
  }
}
