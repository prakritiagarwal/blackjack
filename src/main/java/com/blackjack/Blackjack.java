package com.blackjack;

public class Blackjack {

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");
        Game blackjack = new Game();
        // Game is over when there is no more cards left in the deck 
        // technically we can reshuffle and keep going but to simplify 
        // if someone wants to keep playing they can restart the game
    }
}