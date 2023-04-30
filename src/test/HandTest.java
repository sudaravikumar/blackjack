package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import blackjack.resource.Card;
import blackjack.resource.Deck;
import blackjack.utils.Hand;
import blackjack.utils.Rank;
import blackjack.utils.Suit;

public class HandTest {

	@Test
	void testEmptyCreation() {
		Hand hand = new Hand();
		assertEquals(0, hand.calculatedValue());
	}
	
	@Test
	void testCreation() {
		Hand hand = new Hand();
		Deck deck = new Deck();
		Card card = new Card(Suit.CLUB, Rank.ACE);
		deck.addCard(card);
		hand.takeCardFromDeck(deck);
		assertEquals(11, hand.calculatedValue());
	}
}
