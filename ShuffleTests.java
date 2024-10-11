/*
file name:      ShuffleTests.java
Authors:        Ike Lage & Max Bender & Allen Harper
last modified:  02/26/2024

How to run:     java -ea ShuffleTests
*/

import java.util.ArrayList;
import java.util.Random;

public class ShuffleTests {

    public static void shuffleTestsLab() {
        // case 1: testing that the arrays before and after shuffle are not equal
        {
            // set up
            //Make an array of integers from 0 to 10
             ArrayList<Integer> arr0 = new ArrayList<Integer>();

            for(int i=0;i<=10;i++) {
                arr0.add(i);
            }
            
            //Shuffle it and save the output as a new array
            ArrayList<Integer> arr1 = DumbShuffle.dumbShuffle(arr0);
            // verify
            // Print the original and the shuffled arrays 
            for (int i: arr0){
                System.out.print(arr0.get(i));
            }
            for (int i: arr0){
                System.out.print(arr1.get(i));
            }
            // test
            //Assert that the original and new arrays aren't equal
            System.out.println("arr0.equals(arr1): " + (arr0.equals(arr1)));

            if (arr0.equals(arr1)){
                System.out.println("This Failed the Test.");
            }
            else{
                System.out.println("This Passes the Test.");
            }
        }
       
        //Print that your tests have all passed!
    }

    
    public static void shuffleTestsReflection() {
        // set up
        boolean testPass = true;
        //Make an array of integers from 0 to 10
        ArrayList<Integer> arr0 = new ArrayList<Integer>();
        for(int i=0;i<=10;i++) {
            arr0.add(i);
        }
        arr0 = DumbShuffle.smartShuffle(arr0); // randomizes arr so it is not evenly distributed
        // creates simple array of arr0 length to store total values
        int[] totalValues = new int[arr0.size()];
        //
        for(int i = 0; i <100000; i++){
            //Shuffle it and save the output as a new array
            arr0 = DumbShuffle.smartShuffle(arr0); // this line can switch from dumbshuffle to smartshuffle
            // save new arrayList values to respective slot in totalValues
            for(int j = 0; j < arr0.size(); j++){
                totalValues[j] += arr0.get(j);
            }
        }
        //now that all slots are summed  
        for(int i: totalValues){
            System.out.println(i);
            if (495000 > i || i > 505000){
                
                testPass = false;
            }
        }
        if(testPass){
            System.out.println("You passed the test");
        }
        else{
            System.out.println("You failed the test");
        }
    



    }

    public static void main(String[] args) {
        shuffleTestsReflection();
    }
}