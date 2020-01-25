/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Sean
 */

//values
//A,2,3,4,5,6,7,8,9,T,J,Q,K---W(JOKERS WILD)

public class PlayingCard {
    private final char suitType;
    private final int value;
    
    public PlayingCard(char _suit,int _value){
    suitType=_suit;
    value=_value;
    }

    public char getSuitType() {
        return suitType;
    }

    public int getValue() {
        return value;
    }
    public String toString(){
        String message="Suit : "+suitType+" Value : "+value +"\n";
        
        return message;
    }
    
    
}
