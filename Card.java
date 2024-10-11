public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val
     */
    public Card(int val) {
        if (val >= 1 && val <= 11) {
            // Value is within the valid range
            value = val;
        } else {
            // Value is outside the valid range, so throw an exception
            throw new IllegalArgumentException("Value must be between 1 and 11 inclusive");
        }
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }
    /**
     * Sets the value of the card.
     * @param i : new value
     */
    public void setValue(int i) {
        value = i;
    }
    
    /**
     * Returns a string representation of this card.
     * @return a string representation of this card
     */
    public String toString() {
        return "" + value;
    }
}
