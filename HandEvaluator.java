/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    //hands listed in rank.
    //High Card
    private boolean hasPair; //done
    private boolean hasTwoPair; //done
    private boolean hasThreePair; //done
    private boolean hasStraight; //done
    private boolean hasFlush; 
    private boolean hasFullHouse; //done
    private boolean hasFourPair; //done
    private boolean hasFivePair; //requires wild-card
    private boolean hasStraightFlush;
    
    public HandEvaluator(PokerHand _playHand){
        //puts it all together
    playHand=_playHand;
    pairs=evaluatePairs();
    flush=evaluateSuits();
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
    }
    public int[] evaluatePairs(){
    int pairs[]=new int[13];
    int value;
    for(int i=0;i<playHand.getHand().size();i++){
    value=playHand.getHand().get(i).getValue();
    if(value==99){
    for(int k=0;k<pairs.length;k++){
    pairs[k]++;
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
        hasPair=true;
        }
    }
    }
    public void hasTwoPair(){
    for(int i=0;i<pairs.length;i++){
        if(pairs[i]==2){
            for(int k=0;k<pairs.length;k++){
                if(pairs[k]==2){
        hasTwoPair=true;}}
        }
    }
    }
    public void hasThreePair(){
    for(int i=0;i<pairs.length;i++){
        if(pairs[i]==3){
        hasThreePair=true;
        }
    }
    }
    public void hasFourPair(){
    for(int i=0;i<pairs.length;i++){
        if(pairs[i]==4){
        hasFourPair=true;
        }
    }
    }
    public void hasFivePair(){
    for(int i=0;i<pairs.length;i++){
        if(pairs[i]>=5){
        hasFivePair=true;
        }
    }
    }
     public void hasStraightFlush(){
         hasFlush();
         isStraight();
     if(hasFlush&&hasStraight){
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
    flush[k]++;
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
        straightItem[tempCardValue]=true;
        }
    }
    public void hasFullHouse(){
    for(int i=0;i<pairs.length;i++){
        if(pairs[i]==3){
            for(int k=0;k<pairs.length;k++){
                if(pairs[k]==2){
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
    
   
}
