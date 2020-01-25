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
public class HandEvaluator {
    private PokerHand playHand;
    private int []pairs;
    private int []flush;
    private boolean []straightItem;
    private String HighestHandRank;
    
    private int numberOfWildCards=0;
    //hands listed in rank.
    //High Card
    private boolean hasPair; //done
    private int numbofPair;
    private boolean hasTwoPair; //done
    private int[] numbofTwoPair=new int[2];
    private boolean hasThreePair; //done
    private int numbofThreePair;
    private boolean hasStraight; //done
    private boolean hasFlush; 
    private boolean hasFullHouse; //done
    private int[] numberofFullHouse=new int[2];
    private boolean hasFourPair; //done
    private int numbofFourPair;
    private boolean hasFivePair; //requires wild-card
    private int numbofFivePair;
    private boolean hasStraightFlush;
    
    public HandEvaluator(PokerHand _playHand){
        
        //puts it all together
    playHand=_playHand;
    pairs=evaluatePairs();
    flush=evaluateSuits();
    hasWildCard();
    evaluateStraight();
    isStraight();
    hasPair();
    hasTwoPair();
    hasThreePair();
    hasFourPair();
    hasFivePair();
    hasFullHouse();
    hasFlush();
    hasStraightFlush();
    calculateHighestHandRank();
    
    
    }
    
    
    public int[] evaluatePairs(){
    int pairs[]=new int[13];
    int value;
    for(int i=0;i<playHand.getHand().size();i++){
    value=playHand.getHand().get(i).getValue();
    if(value==99){
    for(int k=0;k<pairs.length;k++){
 //   pairs[k]++;
    }
    }
    else{
    pairs[value]++;
    }
    }
    return pairs;
    }
    
    public void hasPair(){
    for(int i=0;i<pairs.length;i++){
        if(pairs[i]==2){
            numbofPair=i;
        hasPair=true;
        }
    }
    }
    public void hasTwoPair(){
    for(int i=0;i<pairs.length;i++){
        if(pairs[i]==2){
            numbofTwoPair[0]=i;
            for(int k=0;k<pairs.length;k++){
                if(pairs[k]==2&&i!=k){
                    numbofTwoPair[1]=k;
        hasTwoPair=true;}}
        }
    }
    }
    public void hasThreePair(){
    for(int i=0;i<pairs.length;i++){
        if(pairs[i]==3){
            numbofThreePair=i;
        hasThreePair=true;
        }
    }
    }
    public void hasFourPair(){
    for(int i=0;i<pairs.length;i++){
        numbofFourPair=i;
        if(pairs[i]==4){
        hasFourPair=true;
        }
    }
    }
    public void hasFivePair(){
    for(int i=0;i<pairs.length;i++){
        if(pairs[i]>=5){
            numbofFivePair=i;
        hasFivePair=true;
        }
    }
    }
     public void hasStraightFlush(){
         hasFlush();
         isStraight();
     if(hasFlush&&hasStraight){
         //get subset of flush cards, then test for straight
         //subset can be 5<x<13
         hasStraightFlush=true;
         System.out.println("Not Yet implemented");
     
     }
     
     }
    
   
    
    public int[] evaluateSuits(){
    int flush[]=new int[4];
    int suit;
    
    for(int i=0;i<playHand.getHand().size();i++){
    suit=charToNumb(playHand.getHand().get(i).getSuitType());
    if(suit==99){
    for(int k=0;k<flush.length;k++){
  //  flush[k]++;
    }
    }
    else{
    flush[suit]++;
    }
    }
    return flush;
    }
    
    public void evaluateStraight(){
    straightItem=new boolean [13];
    int tempCardValue;
        for(int i=0;i<playHand.getHand().size();i++){
        tempCardValue=playHand.getHand().get(i).getValue();
        if(tempCardValue==99){
        tempCardValue=0;
        }
        straightItem[tempCardValue]=true;
        }
    }
    public void hasFullHouse(){
    for(int i=0;i<pairs.length;i++){
        if(pairs[i]==3){
            numberofFullHouse[0]=i;
            for(int k=0;k<pairs.length;k++){
                if(pairs[k]==2){
                    numberofFullHouse[1]=k;
        hasFullHouse=true;}}
        }
    }
    }
    public void hasFlush(){
   for(int i=0;i<flush.length;i++){
        if(flush[i]>=5){
        hasFlush=true;
        }
                }
    }
    
   
    public void isStraight(){
      int sequence=0;
      boolean isPos=true;
    for (int i=0;i<straightItem.length;i++){
        isPos=true;
        sequence=0;
    for (int k=i;i<9&&k<straightItem.length&&isPos;k++){
    if(straightItem[k]){
    sequence++;
    }
    else if(straightItem[k]==false){
    isPos=false;
    }
    if(sequence==5){
    hasStraight=true;
    }
    }
    }
    
    }
    private int charToNumb(char playingCard){
    int suit=99;
    switch(playingCard){
        case 'H':suit=0;
        break;
        case 'D':suit=1;
        break;
        case 'C':suit=2;
        break;
        case 'S':suit=3;
        break;
        case 'W':
        default: suit=99;
        break;    
    
    }
    return suit;
    }
    
    public String toString(){
    String message="";
    message+="Pairs are \nA 2 3 4 5 6 7 8 9 T J Q K \n";
        for(int i=0;i<pairs.length;i++){
            
             message+=(pairs[i]+" ");   
    }
        message+="\nFlushes are \nH D C S\n";
        for(int i =0;i<flush.length;i++){
            message+=(flush[i]+ "  ");
    }
        message+="\n Straight Info \n";
        for(int i=0;i<straightItem.length;i++){
        if(straightItem[i]){
        message+="T";
        }
        else{
        message+="F";
        }
        message+=" ";
        }
    return message;
    }
    
    public void hasWildCard(){
    for(int i=0;i<playHand.getHand().size();i++){
    if('W'==playHand.getHand().get(i).getSuitType()){
    numberOfWildCards++;
    };
    }
      }
    
    public void calculateHighestHandRank(){
    HighestHandRank="You got a ";
        if(hasStraightFlush){
    HighestHandRank+="Straight Flush!";
    }
    else if(hasFivePair){
    HighestHandRank+="Five of a Kind!";
    }
    else if(hasFourPair){
    HighestHandRank+="Four of a Kind!";    
    }
    else if(hasFullHouse){
    HighestHandRank+="Full House!";
    }
    else if(hasFlush){
    HighestHandRank+="Flush!";
    }
    else if(hasStraight){
    HighestHandRank+="Straight!";
    }
    else if(hasThreePair){
    HighestHandRank+="Three of a Kind!";
    }
    else if(hasTwoPair){
        HighestHandRank+="Two Pairs!";
    }
    else if(hasPair){
     HighestHandRank+="Pair!";
    }
    else{
        HighestHandRank+="High Card!";
    }   
    }

    public boolean isHasPair() {
        return hasPair;
    }

    public boolean isHasTwoPair() {
        return hasTwoPair;
    }

    public boolean isHasThreePair() {
        return hasThreePair;
    }

    public boolean isHasStraight() {
        return hasStraight;
    }

    public boolean isHasFlush() {
        return hasFlush;
    }

    public boolean isHasFullHouse() {
        return hasFullHouse;
    }

    public boolean isHasFourPair() {
        return hasFourPair;
    }

    public boolean isHasFivePair() {
        return hasFivePair;
    }

    public boolean isHasStraightFlush() {
        return hasStraightFlush;
    }

    public String getHighestHandRank() {
        return HighestHandRank;
    }

    public int getNumberOfWildCards() {
        return numberOfWildCards;
    }
    
   
}
