import java.util.ArrayList;

/**
 * Class to simulate Blackjack games with different player and dealer cutoffs,
 * recording the results in a 3D table and printing the outcomes for a specific
 * dealer cutoff range.
 */
public class Simulation {

    /**
     * Main method to run the Blackjack simulation.
     *
     * @param args Command-line arguments (not used in this simulation).
     */
    public static void main(String[] args) {
        // Create a Blackjack object for simulating the game
        Blackjack blackjack = new Blackjack();

        // Initialize a 3D table for storing simulation results with player and dealer cutoff values
        int result = 0;
        /* 
        * This is used for extensions 1 & 3
        final int[][][] table = new int[21][][];

        // Populate the 3D table with arrays for different game outcomes
        for (int i = 0; i < 21; i++) {
            table[i] = new int[21][];
            for (int j = 0; j < 21; j++) {
                table[i][j] = new int[3];
            }
        }

        // Simulate games for various dealer cutoff and player cutoff values
        for (int j = 0; j < 21; j++) {
            blackjack.setDealerCutoff(j);
            for (int k = 0; k < 21; k++) {
                blackjack.setPlayerCutoff(k);
                int[] results = new int[3];

                // Run multiple games for statistical accuracy
                for (int i = 0; i <= 100000; i++) {
                    result = blackjack.game(false) + 1;
                    results[result]++;
                }

                // Store the simulation results in the 3D table
                table[j][k] = results;
            }
        }

        // Display the simulation results for the specified dealer cutoff range
        for (int i = 0; i < 21; i++) {
            System.out.println("\n");
            for (int j = 0; j < 21; j++) {
                System.out.format("Player Hand Cutoff: %d. Dealer Hand Cutoff: %d. Player odds %% is: %.2f%%%15d%15d%15d%n",
                        j, i, (double) (table[i][j][2] - table[i][j][0]) / 1000, table[i][j][0], table[i][j][1], table[i][j][2]);
            }
        }
        */
        // Simulate additional games for a smaller sample size and print the results
        int[] results = new int[3]; 
        for (int i = 0; i < 1000; i++) {
            result = blackjack.game(false) + 1;
            results[result]++;
        }
        System.out.println("Dealer wins is: " + results[0] + " or " + (double) results[0]/10 + "%." +
                            "\nThe number of pushes is: " + results[1] + " or " + (double) results[1]/10 + "%." +
                            "\nThe number of player wins is: " + results[2] + " or " + (double) results[2]/10 + "%.");
        System.out.println();

        
         
    }
}

