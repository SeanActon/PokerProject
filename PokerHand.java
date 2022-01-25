/*
 * This creates a poker hand, based off the program.1
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author Sean
 */
public class PokerHand  {
    private ArrayList<PlayingCard> hand=new ArrayList<PlayingCard>();
    private final Random rng = new Random(2);
    private Deck deck=new Deck();
    
    private void drawCard(){
    int cardToDraw;
    boolean cardDrawn=false;
    do{cardToDraw=rng.nextInt(deck.getDeck().size());
    if(!deck.getCardsDrawn()[cardToDraw]){
    cardDrawn=true;
    deck.setCardsDrawnToTrue(cardToDraw);
    hand.add(deck.getDeck().get(cardToDraw));
    }
    }while(cardDrawn==false);
    }
    public void drawCard(int _toDraw){
    for(int i=0;i<_toDraw;i++){
    drawCard();
        System.out.print(hand.get(hand.size()-1).toString());
        
    }
    System.out.println();
    }
    
    public PokerHand(int draw){
    for(int i=0;i<draw;i++){
    drawCard();
         }
    }
    
    public String toString(){
    String message="";
    for(int i=0;i<hand.size();i++){
    message+=hand.get(i).toString();
        
            }
    return message;
    }

    public ArrayList<PlayingCard> getHand() {
        return hand;
    }
    
    
    
}
