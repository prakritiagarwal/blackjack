package com.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void getNameTest() {
        Player player = new Player();
        assertEquals("Player", player.getName());
    }

    @Test
    public void getHandTest() {
        Player player = new Player();
        assertEquals(0, player.getHand().calculatedValue());
    }
    
}
