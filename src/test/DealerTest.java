package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import blackjack.actor.Dealer;



public class DealerTest {

	@Test
	void testCreation() {
		Dealer dealer = new Dealer();
		assertEquals("Dealer", dealer.getName());
	}
	
	@Test
	void testBusted() {
		Dealer dealer = new Dealer();
		dealer.setBusted(true);
		assertTrue(dealer.hasBusted());
	}
}
