package labs.example.arrays;

import java.util.Scanner;

public class MAIn {

    public static void main(String[] args) {
        arrayOperations arrays = new arrayOperations();

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        arrays.createNewArray(input);
    }
}
