package com.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DeckTest {

    @Test
    public void ConstructorTest()
    {
        Deck deck = new Deck();
        assertEquals(52, deck.getSize());
    }

    @Test
    public void ShuffleTest()
    {
        Deck deck = new Deck();
        deck.shuffleDeck();
        assertEquals(52, deck.getSize());
    }

    @Test
    public void TakeCardTest() 
    {
        Deck deck = new Deck();
        Card card = deck.takeCard();
        assertNotNull(card);
        assertEquals(51, deck.getSize());
    }
    
}
