package com.blackjack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DealerTest {

    @Test
    public void hasBlackJackTest() 
    {
        Dealer dealer = new Dealer();
        Hand hand = dealer.getHand();
        hand.addCardToHand(new Card(Suit.CLUB, Rank.ACE));
        hand.addCardToHand(new Card(Suit.DIAMOND, Rank.JACK));
        assertTrue(dealer.hasBlackJack());
    }

    @Test
    public void doesNotHaveBlackJackTest()
    {
        Dealer dealer = new Dealer();
        Hand hand = dealer.getHand();
        hand.addCardToHand(new Card(Suit.CLUB, Rank.EIGHT));
        hand.addCardToHand(new Card(Suit.DIAMOND, Rank.EIGHT));
        assertFalse(dealer.hasBlackJack());
    }
    
}
