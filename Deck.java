import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck ;
    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */
    public Deck() {
        deck = new ArrayList<Card>();
        build();
    }

    /**
     * Builds the underlying deck as a standard 52 card deck. 
     * Replaces any current deck stored. 
     */
    public void build() {
        deck.clear();
        
        for (int j = 2; j <=11; j++){
            for (int i = 0; i<4; i++){
                deck.add(new Card(j));
                if (j == 10){
                    deck.add(new Card(j));
                    deck.add(new Card(j));
                    deck.add(new Card(j));
                }

            }
        }
        shuffle();
        
    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() {
        Card deal = deck.get(0);
        deck.remove(0);
        return deal; 

    }

    /**
     * Shuffles the cards currently in the deck. 
     */
    public void shuffle() {
        deck = Shuffler.shuffle(deck);
    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() {
        return "" + deck;
    }
}
