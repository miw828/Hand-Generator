# Hand-Generator
Java homework that generates a card hand 
//Mia Ware miw828
//Homework 06
//10/30/2024

import java.util.Scanner;
import java.util.Random; 
public class HandGenerator{
    public static void main(String [] args){
         Scanner myScanner = new Scanner(System.in);
        Random randomGenerator = new Random();
        int card1, card2, card3, card4, card5=0;
        
            
            while(true){
            System.out.println("Would you like to choose your cards or have them random? (choose/random)");
            String input = myScanner.next();
            // Here are two switch statements for choose and random 
            switch (input){
                case "choose": 
                
                while(true){
                System.out.print("First card: "); 
                card1 = myScanner.nextInt(); 
                System.out.print("Second card: ");
                card2 = myScanner.nextInt();
                System.out.print("Third card: ");
                card3 = myScanner.nextInt();
                System.out.print("Fourth card: ");
                card4 = myScanner.nextInt();
                System.out.print("Fifth card: ");
                card5 = myScanner.nextInt();
                // This makes it so there are no duplicate cards in the choose case 
                if(card1 == card2 || card1 == card3 || 
                card1 == card4 || card1 == card5 || card2 == card3 ||
                 card2 == card4 || card2 == card5 || card3 == card4 || 
                 card3 == card5 || card4 == card5){
                    System.out.println("Card numbers cannot be the same please choose again.");
                 } else if ((card1>51 || card1<0)||(card2>51 || card2<0)||(card3>51 || card3<0)||(card4>51 || card4<0)||(card5>51 || card5<0)){
                  System.out.println("Card number cannot be greater than 51 or less than 0");
                 }

                 else {
                 
                    break; 
                 }
                }
                    
                break; 

                case "random":
                while(true){
               // this will randomize all 5 cards 
                card1 = randomGenerator.nextInt(52);
                card2 = randomGenerator.nextInt(52);
                card3 = randomGenerator.nextInt(52);
                card4 = randomGenerator.nextInt(52);
                card5 = randomGenerator.nextInt(52);
                // this makes the generator remake itself if the first one generates duplicate cards 
                if(card1 == card2 || card1 == card3 || 
                card1 == card4 || card1 == card5 || card2 == card3 ||
                 card2 == card4 || card2 == card5 || card3 == card4 || 
                 card3 == card5 || card4 == card5){
                    card1 = randomGenerator.nextInt(52);
                    card2 = randomGenerator.nextInt(52);
                    card3 = randomGenerator.nextInt(52);
                    card4 = randomGenerator.nextInt(52);
                    card5 = randomGenerator.nextInt(52);
                 } else {
                    
                    break; 
                 }
                }
                
                    
                break; 
                 
            default: 
            System.out.println("Please input either choose or random. "); 
             continue; 
            }
              System.out.println(scoreHand(card1, card2, card3, card4, card5)); 

              // This will ask the user if they want to play again and if they type y will restart the main method
              System.out.println("Would you like to play again? (y/n)");
              String playAgain = myScanner.next();
              switch (playAgain){
                case "y":
                  continue;
                case "n":
                  break;
                  default: 
                  System.out.println("please choose y or n. ");
                  continue;
              }
          break; 
             
        }
      
    }
    // This determines the suit of the card 
    public static String suit(int card){
      if (card >= 0 && card <=12){
        return "clubs"; 
      } else if(card >= 13 && card <=25){
      return "diamonds";
    } else if(card >= 26 && card <=38){
      return "hearts";
    } else if(card >= 39 && card <=51){
      return "spade";
    }
    return "unknown";
    }
    // This determines the rank of the card
    public static String rank(int card){
      int numRank = (card+1)%13; 
      switch(numRank) {
        case 0:
          return "ace";
        case 11: 
          return "jack";
        case 12: 
          return "queen";
        case 13: 
          return "king";
        default: 
          return numRank +" ";
      }
      // this is the integer version of the rank because java does not allow to compare strings 
      // this was created for the high card test. 
} public static int otherRank(int card){
  return card % 13; 
}
    // This will determine what the highest card is 
    public static String highCardTest(int card1, int card2, int card3, int card4, int card5){
     
      if (otherRank(card1) > otherRank(card2)||otherRank(card1) > otherRank(card3)||otherRank(card1) > otherRank(card4)||otherRank(card1)>otherRank(card5)){
        return otherRank(card1)+ " "+ suit(card1) + " is the highest card";
      } else if (otherRank(card2)>otherRank(card1)||otherRank(card2)>otherRank(card3)||otherRank(card2)>otherRank(card4)||otherRank(card2)>otherRank(card5)){
         return otherRank(card2)+ " "+ suit(card2) + " is the highest card";  
      } else if (otherRank(card3)>otherRank(card1)||otherRank(card3)>otherRank(card2)||otherRank(card3)>otherRank(card4)||otherRank(card3)>otherRank(card5)){
         return otherRank(card3)+ " "+ suit(card3) + " is the highest card";
      } else if (otherRank(card4)>otherRank(card1)||otherRank(card4)>otherRank(card3)||otherRank(card4)>otherRank(card2)||otherRank(card4)>otherRank(card5)){
        return otherRank(card4)+ " "+ suit(card4) + " is the highest card";
      }else if (otherRank(card5)>otherRank(card1)||otherRank(card5)>otherRank(card3)||otherRank(card5)>otherRank(card4)||otherRank(card5)>otherRank(card2)){
         return otherRank(card5)+ " "+ suit(card5) + " is the highest card";
      } else {
        return null;
      }
    }


     // This will complete the pair test 
    public static String pairTest(int card1, int card2, int card3, int card4, int card5){
      if (rank(card1).equalsIgnoreCase(rank(card2))||rank(card1).equalsIgnoreCase(rank(card3))||rank(card1).equalsIgnoreCase(rank(card4))||rank(card1).equalsIgnoreCase(rank(card5))||
      rank(card2).equalsIgnoreCase(rank(card3))||rank(card2).equalsIgnoreCase(rank(card4))||rank(card2).equalsIgnoreCase(rank(card5))||rank(card3).equalsIgnoreCase(rank(card4))|| rank(card3).equalsIgnoreCase(rank(card5))
      ||rank(card4).equalsIgnoreCase(rank(card5))){
        return "You have a pair";
      }else {
        return null; 
      }
        
    }// This completes the two pair test 
    public static String twoPairTest(int card1, int card2, int card3, int card4, int card5){
        if((rank(card1).equalsIgnoreCase(rank(card2))&& 
        rank(card3).equalsIgnoreCase(rank(card4)))||
        (rank(card1).equalsIgnoreCase(rank(card2)))&&
        (rank(card3).equalsIgnoreCase(rank(card5)))||
        (rank(card1).equalsIgnoreCase(rank(card2)))&&
        (rank(card4).equalsIgnoreCase(rank(card5)))||
         (rank(card2).equalsIgnoreCase(rank(card3))&&
         (rank(card1)).equalsIgnoreCase(rank(card4)))||
        (rank(card2).equalsIgnoreCase(rank(card3)))&&
        (rank(card1).equalsIgnoreCase(rank(card5)))|| 
        (rank(card2).equalsIgnoreCase(rank(card3)))&&
        (rank(card4).equalsIgnoreCase(rank(card5)))||
        (rank(card3).equalsIgnoreCase(rank(card4)))&&
        (rank(card2).equalsIgnoreCase(rank(card5)))||
        (rank(card3).equalsIgnoreCase(rank(card4)))&&
        (rank(card1).equalsIgnoreCase(rank(card5)))||
        (rank(card4).equalsIgnoreCase(rank(card5)))&&
        (rank(card1).equalsIgnoreCase(rank(card3)))){
          return "There is a Two Pair";
        }else {
          return null; 
        }
    }
    // This will create the Three of a Kind Test 
    public static String threeOfAKindTest(int card1, int card2, int card3, int card4, int card5){ 
       if((rank(card1).equalsIgnoreCase(rank(card2)) && rank(card2).equalsIgnoreCase(rank(card3))) || 
       (rank(card1).equalsIgnoreCase(rank(card2)) && rank(card2).equalsIgnoreCase(rank(card4))) || 
      (rank(card1).equalsIgnoreCase(rank(card2)) && rank(card2).equalsIgnoreCase(rank(card5))) || 
      (rank(card1).equalsIgnoreCase(rank(card3)) &&rank(card3).equalsIgnoreCase(rank(card4))) ||
      (rank(card1).equalsIgnoreCase(rank(card3)) && rank(card3).equalsIgnoreCase(rank(card5))) ||
       (rank(card1).equalsIgnoreCase(rank(card4)) &&rank(card4).equalsIgnoreCase(rank(card5))) ||
      (rank(card2).equalsIgnoreCase(rank(card3)) && rank(card3).equalsIgnoreCase(rank(card4)))|| 
      (rank(card2).equalsIgnoreCase(rank(card3)) && rank(card3).equalsIgnoreCase(rank(card5))) ||
      (rank(card2).equalsIgnoreCase(rank(card4)) && rank(card4).equalsIgnoreCase(rank(card5))) ||
       (rank(card3).equalsIgnoreCase(rank(card4)) &&rank(card4).equalsIgnoreCase(rank(card5)))){
       
      return "Three of a kind";
      }else {
      return null; 
      }
    } //This tests for a Flush amoung the cards. 
    public static String flushTest(int card1, int card2, int card3, int card4, int card5){
      if(suit(card1)==suit(card2)&&suit(card2)==suit(card3)&&suit(card3)==suit(card4)&&suit(card4)==suit(card5)){
        return "You have a: " + suit(card1) + " Flush.";
      }else {
        return null;
      }
       
    } // This is the final method that will score the hand 
    public static String scoreHand(int card1, int card2, int card3, int card4, int card5) {
    if (flushTest(card1, card2, card3, card4, card5) != null) {
        return flushTest(card1, card2, card3, card4, card5);
    } else if (threeOfAKindTest(card1, card2, card3, card4, card5) != null) {
        return threeOfAKindTest(card1, card2, card3, card4, card5);
    } else if (twoPairTest(card1, card2, card3, card4, card5) != null) {
        return twoPairTest(card1, card2, card3, card4, card5);
    } else if (pairTest(card1, card2, card3, card4, card5) != null) {
        return pairTest(card1, card2, card3, card4, card5);
    } else if (highCardTest(card1, card2, card3, card4, card5) != null) {
        return highCardTest(card1, card2, card3, card4, card5);
    }
    return null; 
}
}



