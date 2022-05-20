package com.blackjack;

import java.util.Random;

public class Card {

    private Suit suit;
    private Rank rank;

    // create arrays for values and suits - need these to generate random cards
    private Rank[] values = Rank.values();
    private Random randomValues = new Random();
    private Suit[] suits = Suit.values();
    private Random randomSuits = new Random();

    public Card(Suit suit, Rank value) {
        this.rank = value;
        this.suit = suit;
    }

    // random card generated
    public Card() {
        this.suit = getRandomSuit();
        this.rank = getRandomValue();
    }

    public Card(Card card) {
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    public String toString() {
        return this.suit.toString() + "-" + this.rank.toString();
    }

    public int getValue() {
        return this.rank.rankValue;
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public Rank getRandomValue() {
        return values[randomValues.nextInt(values.length)];
    }

    public Suit getRandomSuit() {
        return suits[randomSuits.nextInt(values.length)];
    }
}