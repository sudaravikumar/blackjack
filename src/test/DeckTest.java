package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import blackjack.resource.Card;
import blackjack.resource.Deck;

public class DeckTest {

	@Test
	void testEmptyCreation() {
		Deck deck = new Deck();
		assertEquals(0, deck.getCards().size());
	}
	
	@Test
	void testCreation() {
		Deck deck = new Deck(true);
		assertEquals(52, deck.getCards().size());
	}
	
	@Test
	void testTakeCard() {
		Deck deck = new Deck(true);
		assertEquals(52, deck.getCards().size());
		Card card = deck.takeCard();
		assertEquals(51, deck.getCards().size());
		assertNotNull(card);
	}
	
	@Test
	void testHasCard() {
		Deck deck = new Deck(true);
		assertEquals(52, deck.getCards().size());
		assertTrue(deck.hasCards());
	}
}
