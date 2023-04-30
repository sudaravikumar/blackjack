package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import blackjack.actor.Player;

public class PlayerTest {
	@Test
	void testCreation() {
		Player player = new Player(1);
		assertEquals("Player 1", player.getName());
	}
	
	@Test
	void testBusted() {
		Player player = new Player(1);
		player.setBusted(true);
		assertTrue(player.hasBusted());
	}
}
