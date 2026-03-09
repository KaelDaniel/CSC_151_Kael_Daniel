package labs.example.arrays;

import java.util.Scanner;

public class MAIn {

    public static void main(String[] args) {
        arrayOperations arrays = new arrayOperations(); //creates a new array for use

        Scanner scanner = new Scanner(System.in); //sets up the scanner system for inputs

        int input = scanner.nextInt(); // intiger input

        arrays.createNewArray(input); //calls for the public array in arrayOperations, with the given input as the value

        int[] sortedArrays = new int[50]; //creates a new array with 50 slots

        for (int num = 0; num < sortedArrays.length; num++) { //a for loop that sets each slot in the second array with a random number from 1 to 100
            sortedArrays[num] = (int)(Math.random() * 100);
        }

        arrayOperations.sortArray(sortedArrays); //calls for the public class that will sort the 50 random slots in the second array

        arrayOperations.getDaysAndMonths(); //calls for the array that lists the 12 months and how many days are in each one
    }
}
