import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;
    /**
     * Creates an empty hand as an ArrayList of Cards.  
     */
    public Hand(){
        cards = new ArrayList<Card>();
    }

    /**
     * Removes any cards currently in the hand. 
     */
    public void reset(){
        cards.clear();
    }

    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card){
        cards.add(card);
    }

    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size(){
        return cards.size();
    }

    /**
     * Returns the card in the hand specified by the given index. 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index){
        return cards.get(index);
    }
    
    /**
     * Checks the hand for an Ace with a value of 11 and updates its value to 1.
     * Assumes there is only one Ace to update.
     * break to not update both if two aces
     */
    public void checkAndUpdateAce() {
        for (Card card : cards) {
            if (card.getValue() == 11) {
                card.setValue(1);
                return;
            }
            
        }
    }

    /**
     * Checks the hand for an Ace with a value of 11.
     * Assumes there is only one Ace to update.
     * break to not update both if two aces
     */
    public boolean checkAce() {
        for (Card card : cards) {
            if (card.getValue() == 11) {
                return true;
            }
            
        }
        return false;
    }
    /**
     * Checks the hand for an Ace with a value of 11.
     * Assumes there is only one Ace to update.
     * break to not update both if two aces
     */
    public void addOne(){
        cards.get(0).setValue(cards.get(0).getValue() + 1);
    }

    /**
     * Returns the cards in the handd. 
     * @return the cards in the hand.
     */
    public ArrayList<Card> getCards(){
        return cards;
    }


    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue(){
        int sum = 0;
        for (Card card: cards){
            sum += card.getValue();
        } 
        return sum;
    }

    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    public String toString(){
        return "" + cards + " : " + getTotalValue();
    }
}
