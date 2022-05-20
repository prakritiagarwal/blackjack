package com.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HandTest {

    @Test
    public void calculatedValueTest()
    {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.CLUB, Rank.EIGHT));
        assertEquals(8, hand.calculatedValue());
    }

    @Test
    public void getCardTest()
    {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.CLUB, Rank.EIGHT));
        Card card = hand.getCard(0);
        assertEquals(Suit.CLUB, card.getSuit());
    }

    @Test
    public void hasBustedTest()
    {
        Hand hand = new Hand();
        hand.addCardToHand(new Card(Suit.CLUB, Rank.EIGHT));
        hand.addCardToHand(new Card(Suit.DIAMOND, Rank.EIGHT));
        hand.addCardToHand(new Card(Suit.SPADE, Rank.EIGHT));
        assertTrue(hand.hasBusted());
    }
    
}
