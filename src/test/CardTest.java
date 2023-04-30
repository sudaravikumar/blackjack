package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import blackjack.resource.Card;
import blackjack.utils.Rank;
import blackjack.utils.Suit;

public class CardTest {

	@Test
	void testCreation() {
		Card card = new Card(Suit.CLUB, Rank.ACE);
		assertEquals(Rank.ACE, card.getRank());
		assertEquals(Suit.CLUB, card.getSuit());
	}
}
