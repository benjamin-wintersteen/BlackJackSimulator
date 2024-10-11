/**
 * The Blackjack class represents a simplified Blackjack game simulation.
 * It includes methods for game initialization, player and dealer turns, reshuffling,
 * and handling Ace values. The class can be used to run multiple Blackjack games
 * and analyze the results.
 */
public class Blackjack {
    private int reshuffleCutoff;
    private Deck deck = new Deck(); 
    private Hand playerHand = new Hand();
    private Hand dealerHand = new Hand();
    private int playerCutoff = 16;
    private int dealerCutoff = 17;

    /**
     * Constructs a Blackjack instance with a specified reshuffle cutoff.
     *
     * @param reshuffleCutoff The cutoff value for reshuffling the deck.
     */
    public Blackjack(int reshuffleCutoff){
        this.reshuffleCutoff = reshuffleCutoff;
        reset();
    }

    /**
     * Constructs a Blackjack instance with a default reshuffle cutoff.
     */
    public Blackjack(){
       this((int) 30);
    }

    /**
     * Resets the game by clearing hands and reshuffling the deck if necessary.
     */
    public void reset(){
        playerHand.reset();
        dealerHand.reset();
        if(deck.size() < reshuffleCutoff){
            deck.build();
            deck.shuffle();
        }
    }

    /**
     * Deals two cards each to the player and the dealer at the beginning of the game.
     */
    public void deal(){
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
    }

    /**
     * Simulates the player's turn in the Blackjack game.
     * Checks for Ace value adjustment during the turn.
     *
     * @param cutoff The cutoff value for the player's hand.
     * @return {@code true} if the player's hand exceeds 21 after the turn; {@code false} otherwise.
     */
    public boolean playerTurn(int cutoff){
        while(playerHand.getTotalValue() < cutoff){
            playerHand.add(deck.deal());
            if(playerHand.getTotalValue() > 21 && playerHand.checkAce()){
                playerHand.checkAndUpdateAce();
            }
        }
        if(playerHand.getTotalValue() > 21){
            return true;
        }
        return false;
    }

    /**
     * Simulates the dealer's turn in the Blackjack game.
     * Checks for Ace value adjustment during the turn.
     *
     * @param cutoff The cutoff value for the dealer's hand.
     * @return {@code true} if the dealer's hand exceeds 21 after the turn; {@code false} otherwise.
     */
    public boolean dealerTurn(int cutoff){
        while(dealerHand.getTotalValue() < cutoff){
            dealerHand.add(deck.deal());
        }
        if(dealerHand.getTotalValue() > 21){
            return true;
        }
        return false;
    }

    /**
     * Sets the reshuffle cutoff value.
     *
     * @param cutoff The reshuffle cutoff value.
     */
    public void setReshuffleCutoff(int cutoff){
        reshuffleCutoff = cutoff;
    }

    /**
     * Retrieves the reshuffle cutoff value.
     *
     * @return The reshuffle cutoff value.
     */
    public int getReshuffleCutoff(){
        return reshuffleCutoff;
    }

    /**
     * Generates a string representation of the current game state.
     *
     * @return A string representing the player's and dealer's hands with their total values.
     */
    public String toString(){
        return "Player Hand is: " + playerHand + " with total value: " + playerHand.getTotalValue() +
               ". Dealer Hand is: " + dealerHand + " with total value: " + dealerHand.getTotalValue(); 
    }

    /**
     * Simulates a complete Blackjack game, including dealing cards, player and dealer turns,
     * and determining the winner. Optionally prints the results if verbose is set to true.
     *
     * @param verbose Whether to print detailed results.
     * @return The game result: 1 for player win, -1 for dealer win, 0 for a push.
     */
    public int game(boolean verbose){
        String gameState;
        String initialPlayerHand;
        String initialDealerHand;
        int game;
        reset();

        // Deal initial cards
        deal();
        initialPlayerHand = playerHand.toString();
        initialDealerHand = dealerHand.toString();

        // Player's turn
        playerTurn(playerCutoff);
        if(initialPlayerHand.equals(playerHand.toString()) && playerHand.getTotalValue() == 21){
            // Check for a natural Blackjack and add one to the hand
            playerHand.addOne();
        }
        int playerValue = playerHand.getTotalValue();
        if(playerHand.getTotalValue() > 21){
            playerValue = 0; // Player busts
        }
        else{
            // Dealer's turn
            dealerTurn(dealerCutoff);
            if(initialDealerHand.equals(dealerHand.toString()) && dealerHand.getTotalValue() == 21){
                // Check for a natural Blackjack and add one to the hand
                dealerHand.addOne();
            }
        }
        
        // Display the final game state
        toString();
        
        int dealerValue = dealerHand.getTotalValue();
        if(dealerHand.getTotalValue() > 21){
            dealerValue = 0; // Dealer busts
        }

        // Determine the winner
        if(playerValue > dealerValue){
            gameState = "player";
            game = 1; // Player wins
        }
        else if(playerValue < dealerValue){
            gameState = "dealer";
            game = -1; // Dealer wins
        }
        else{
            gameState = "push";
            game = 0; // Push (tie)
        }

        // Print detailed results if verbose is set to true
        if (verbose){
            System.out.println("The initial player hand was: " + initialPlayerHand + 
                               "\nThe initial dealer hand was: " + initialDealerHand + 
                               "\nThe final player hand was: " + playerHand.toString()+
                               "\nThe final dealer hand was: " + dealerHand.toString()+
                               "\nThe result is: "+ gameState);
        }
        
        return game;
    }

    /**
     * Sets the player cutoff value for the player's turn.
     *
     * @param i The player cutoff value.
     */
    public void setPlayerCutoff(int i){
        playerCutoff = i;
    }

    /**
     * Sets the dealer cutoff value for the dealer's turn.
     *
     * @param i The dealer cutoff value.
     */
    public void setDealerCutoff(int i){
        dealerCutoff = i;
    }

    /**
     * Main method to run a single Blackjack game and print the result.
     *
     * @param args Command-line arguments (not used in this method).
     */
    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        System.out.println(blackjack.game(true));
        System.out.println(blackjack.game(true));
        System.out.println(blackjack.game(true));
    }
}

