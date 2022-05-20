package com.blackjack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
    }   
    
    public void addCardToHand(Card card){
        hand.add(card);
    }

    public String toString(){
        String output = "";
        for(Card card: hand){
            output += card + " - ";
        }
        return output;
    }

    public int calculatedValue(){
        //variable to count number of aces, and current total value
        int value = 0;
        int aceCount = 0;
    
        //For each card in this hand
        for(Card card: hand){
            //Add the card value to the hand
            value += card.getValue();
            //Count how many aces have been added
            if (card.getValue() == 11){
                aceCount ++;
            }
        }
        //if we have a scenario where we have multiple aces, as may be the case of drawing 10, followed by two or more aces, (10+11+1 > 21)
        //go back and set each ace to 1 until get back under 21, if possible
        if (value > 21 && aceCount > 0){
            while(aceCount > 0 && value > 21){
                aceCount --;
                value -= 10;
            }
        }
        return value;    
    }

    public boolean hasBusted() {
        return calculatedValue() > 21;
    }

    public Card getCard(int idx){
        return hand.get(idx);
    }
}
