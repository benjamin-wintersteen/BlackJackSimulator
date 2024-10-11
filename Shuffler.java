/**
* Author: Benjamin Wintersteen
* 
* This class will shuffle a deck of cards
*/
import java.util.ArrayList;
import java.util.Random;
public class Shuffler {
    
    private static int[] testSpread;
    public static void main (String[] args) { 
        ArrayList<Integer> arr0 = new ArrayList<Integer>();
        Random ran = new Random();

        for(int i=0;i<10;i++) {
            arr0.add(ran.nextInt(100));
        }
        for (int i: arr0){
            System.out.println(arr0.get(i));
        }
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        for (int i=0;i<10;i++){
            arr1.add(arr0.get(i));
        }
        ArrayList<Integer> arr2 = arr0;
        System.out.println("arr0 == arr1: " + (arr0 == arr1) + "\narr1 == arr2: " + (arr1 == arr2) + "\narr2 == arr0: " + (arr2 == arr0));
        System.out.println("arr0.equals(arr1): " + (arr0.equals(arr1)) + "\narr1.equals(arr2): " + (arr1.equals(arr2)) + "\narr2.equals(arr0): " + (arr2.equals(arr0)));
    }
    public static ArrayList <Card> shuffle (ArrayList <Card> deck){
        ArrayList<Card> newDeck = new ArrayList<Card>();
        int deckSize = deck.size();
        final int DECKSIZE = deck.size();
        int cardIndex;
        Random ran = new Random();
        for (int i = 1; i <= DECKSIZE; i++){
            cardIndex = ran.nextInt(deckSize);
            newDeck.add(deck.get(cardIndex));
            deck.remove(cardIndex);
            deckSize--;
        }
        return newDeck;
    }
    public static String getTestSpread() {
        String result = "";
        int index = 0;
        for (int i: testSpread){
            result += "There are " + i + " 9s at index " + index + ".";
            index++;
        }
        return result;
    }

}