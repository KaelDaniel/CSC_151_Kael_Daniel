package labs.example.arrays;

import java.util.Scanner;

public class MAIn {

    public static void main(String[] args) {
        arrayOperations arrays = new arrayOperations();

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        arrays.createNewArray(input);

        int[] sortedArrays = new int[50];

        for (int num = 0; num < sortedArrays.length; num++) {
            sortedArrays[num] = (int)(Math.random() * 100);
        }

        arrayOperations.sortArray(sortedArrays);
    }
}
