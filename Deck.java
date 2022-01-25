/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.1
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class Deck {
    private ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();
    private boolean cardsDrawn []= new boolean [54];

    
       
    public Deck(){
        setDeck();
    }
    
   public void resetDeck(){
       for(int i=0;i<cardsDrawn.length;i++){
   cardsDrawn[i]=false;
   }
   }
   private void setDeck(){
   char currentSuit='F';
   char currentValue;
       for (int i=0;i<4;i++){
   switch(i){
       case 0:
           currentSuit='H';
           break;
       case 1:
           currentSuit='D';
           break;
       case 2:
           currentSuit='C';
           break;
       case 3:
           currentSuit='S';
           break;
   }
        for (int k=0;k<13;k++){
            deck.add(new PlayingCard(currentSuit,k));
        }
   }
      //deck.add(new PlayingCard('W',99));
      //deck.add(new PlayingCard('W',99));
   }
   
   public boolean[] getCardsDrawn() {
        return cardsDrawn;
    }

    public void setCardsDrawnToTrue(int cardToDraw) {
       cardsDrawn[cardToDraw]=true;
    }

    public ArrayList<PlayingCard> getDeck() {
        return deck;
    }

    
}
