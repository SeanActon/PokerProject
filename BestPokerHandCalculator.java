/*
 * This program takes a collection of poker cards, ranging from 5-54 (2 jokers)
   and makes the best 5 card poker hand with it. Intended use is for Deadlands 
   RPG huckster characters
 */
package main;



/*
planned features-

4.Jokers?<-1st
5. High Aces? 2nd

fix 1 pair, 2 pair 3 of a kind, 4 of a kind to be <= rather than exact.
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
    
    boolean forPair=false;
    int z=0;
    
            z++;
        int []pairs;
        int []flush;
       
         PokerHand pHand = new PokerHand(30);
         
         HandEvaluator rate = new HandEvaluator(pHand);
         pairs=rate.evaluatePairs();
         flush=rate.evaluateSuits();
         rate.evaluateStraight();
         System.out.println(pHand.toString());
           finalEvaluation(rate);
         PokerHand hs=rate.calculateHighestHandRank();
         System.out.println(hs.toString());
      
    }
    public static void finalEvaluation(HandEvaluator rate){
             

System.out.println(rate.toString());
System.out.println("-------------------open-------------------");
         System.out.println("has straight");
         System.out.println(rate.isHasStraight());
         System.out.println("has flush");
         System.out.println(rate.isHasFlush());
         System.out.println("has pair");
         System.out.println(rate.isHasPair());
         System.out.println("has 2 pair");
         System.out.println(rate.isHasTwoPair());
         System.out.println("has 3 pair");
         System.out.println(rate.isHasThreePair());
         System.out.println("has 4 pair");
         System.out.println(rate.isHasFourPair());
         System.out.println("has 5 pair");
         System.out.println(rate.isHasFivePair());
         System.out.println("has full house");
         System.out.println(rate.isHasFullHouse());
         System.out.println("Has straight flush");
         System.out.println(rate.isHasStraightFlush());
         System.out.println("Wild Cards are "+rate.getNumberOfWildCards());
         System.out.println(rate.getHighestHandRank());
        
    
    }
}



//         for(int i=0;i<pairs.length;i++){
//             System.out.print(pairs[i]+" ");   
//    }
//         System.out.println("");
//        System.out.println("H D C S W");
//    for(int i =0;i<flush.length;i++){
//        System.out.print(flush[i]+ " ");
//    }
//    }
