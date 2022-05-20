package com.blackjack;

public abstract class Person {

    private Hand hand;
    private String name;

    public Person(){
        this.hand = new Hand();
        this.name = "";
    }

    public Hand getHand(){
        return this.hand;
    }

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;    
    }

    public void discardHand() {
        this.hand = new Hand();
    }

    public boolean hasBlackJack() {
        if(this.getHand().calculatedValue() == 21)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }    
}
