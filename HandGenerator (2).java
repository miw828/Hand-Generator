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
              System.out.println("rank:");
              System.out.println(rank(card1)+ " " +rank(card2)+ " " + rank(card3)+ " "+ rank(card4)+" "+rank(card5));

              System.out.println("suit:");
              System.out.println(suit(card1)+ ", "+(suit(card2))+", "+(suit(card3))+"," + (suit(card4))+","+(suit(card5)));
            
              System.out.println("Three Kind" + (threeKindTest(card1, card2, card3,  card4, card5)));
               System.out.println("Flush:" + flushTest(card1, card2, card3,  card4, card5));
              System.out.println("pair" + pairTest(card1, card2, card3,  card4, card5));
              System.out.println("two pair" + twoPairTest(card1, card2, card3,  card4, card5));
          break; 
             
        }
      
    }
    // 0-12 Clubs
    // 13-25 Diamonds
    // 26-38 Hearts
    // 40-51 Spades 
    public static String suit(int card){
      if (card >= 0 && card <=12){
        return "clubs"; 
      } else if(card >= 13 && card <=25){
      return "diamonds";
    } else if(card >= 26 && card <=38){
      return "hearts";
    } else if(card >= 40 && card <=51){
      return "spade";
    }
    return "unknown";
    }
    public static String rank(int card){
      int numRank = (card+1)%13; 
      switch(numRank) {
        case 1:
          return "ace";
        case 11: 
          return "jack";
        case 12: 
          return "queen";
        case 13: 
          return "king";
        default: 
          return numRank+"";
      }
}

    // public static boolean highCardTest(){

    // }
    public static String pairTest(int card1, int card2, int card3, int card4, int card5){
      if (rank(card1)==rank(card2)||rank(card1)==rank(card3)||rank(card1)==rank(card4)||rank(card1)==rank(card5)||
      rank(card2)==rank(card3)||rank(card2)==rank(card4)||rank(card2)==rank(card5)||rank(card3)==rank(card4)|| rank(card3)==rank(card5)
      ||rank(card4)==rank(card5)){
        return "You have a pair";
      }else {
        return null; 
      }
        
    }
    public static String twoPairTest(int card1, int card2, int card3, int card4, int card5){
        if(((rank(card1)==rank(card2))&&(rank(card3)==rank(card4))|| (rank(card1)==rank(card2))&&(rank(card3)==rank(card5)))||
        ((rank(card1)==rank(card2))&&(rank(card4)==rank(card5)))|| ((rank(card2)==rank(card3))&&(rank(card1)==rank(card4)))||
        ((rank(card2)==rank(card3))&&(rank(card1)==rank(card5)))|| ((rank(card2)==rank(card3))&&(rank(card4)==rank(card5)))||
        ((rank(card3)==rank(card4))&&(rank(card2)==rank(card5)))||((rank(card3)==rank(card4))&&(rank(card1)==rank(card5)))||
        ((rank(card4)==rank(card5))&&(rank(card1)==rank(card3)))){
          return "There is a Two Pair";
        }else {
          return null; 
        }
    }
    public static String threeKindTest(int card1, int card2, int card3, int card4, int card5){ 
       if((rank(card1).equalsIgnoreCase(rank(card2)) && rank(card2).equalsIgnoreCase(rank(card3))) || (rank(card1).equalsIgnoreCase(rank(card2)) && rank(card2).equalsIgnoreCase(rank(card4))) || 
      (rank(card1).equalsIgnoreCase(rank(card2)) && rank(card2).equalsIgnoreCase(rank(card5))) || (rank(card1).equalsIgnoreCase(rank(card3)) &&rank(card3).equalsIgnoreCase(rank(card4))) ||
      (rank(card1).equalsIgnoreCase(rank(card3)) && rank(card3).equalsIgnoreCase(rank(card5))) || (rank(card1).equalsIgnoreCase(rank(card4)) &&rank(card4).equalsIgnoreCase(rank(card5))) ||
      (rank(card2).equalsIgnoreCase(rank(card3)) && rank(card3).equalsIgnoreCase(rank(card4)))|| (rank(card2).equalsIgnoreCase(rank(card3)) && rank(card3).equalsIgnoreCase(rank(card5))) ||
      (rank(card2).equalsIgnoreCase(rank(card4)) && rank(card4).equalsIgnoreCase(rank(card5))) || (rank(card3).equalsIgnoreCase(rank(card4)) &&rank(card4).equalsIgnoreCase(rank(card5)))){
       
      return "Three of a kind";
      }else {
      return null; 
      }
    }
    public static String flushTest(int card1, int card2, int card3, int card4, int card5){
      if(suit(card1)==suit(card2)&&suit(card2)==suit(card3)&&suit(card3)==suit(card4)&&suit(card4)==suit(card5)){
        return "You have a: " + suit(card1) + " Flush.";
      }else {
        return null;
      }
           
    }
}


