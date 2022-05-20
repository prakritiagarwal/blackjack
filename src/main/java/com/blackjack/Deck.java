package com.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;    

    public Deck(){
        deck = new ArrayList<Card>();                    
        for(Suit suit : Suit.values()){                
            for(Rank rank : Rank.values()){                    
                deck.add(new Card(suit, rank));
            }
        }        
    }    

    public int getSize()
    {
        return deck.size();
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }    

    public Card takeCard(){
        if(deck.size() == 0)
            return null;        
     
        Card cardToTake = deck.get(0);     
        deck.remove(0);        
        return cardToTake;
    }    

}