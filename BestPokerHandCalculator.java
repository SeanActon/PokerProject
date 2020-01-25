/*
 * This program takes a collection of poker cards, ranging from 5-54 (2 jokers)
   and makes the best 5 card poker hand with it. Intended use is for Deadlands 
   RPG huckster characters
 */
package main;
/*
planned features-

2.Calculate Hands
3.Weigh Hands properly
4.Jokers
5.Alternative input, pull from tts?.
*/
/**
 *
 * @author Sean
 */
public class BestPokerHandCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       boolean straightFound=false;
        do{
        int []pairs;
        int []flush;
         PokerHand pHand = new PokerHand(5);
         
         HandEvaluator rate = new HandEvaluator(pHand);
         pairs=rate.evaluatePairs();
         flush=rate.evaluateSuits();
         rate.evaluateStraight();
         System.out.println(pHand.toString());
         
//         for(int i=0;i<pairs.length;i++){
//             System.out.print(pairs[i]+" ");   
//    }
//         System.out.println("");
//        System.out.println("H D C S W");
//    for(int i =0;i<flush.length;i++){
//        System.out.print(flush[i]+ " ");
//    }
//    }
System.out.println(rate.toString());
System.out.println("open---------------------------\n \n ");
         System.out.println(rate.isHasStraight());
        
         if(rate.isHasStraight()){
         straightFound=true;
         }
        
        }while(!straightFound);
    }}
    
    

