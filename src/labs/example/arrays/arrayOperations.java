package labs.example.arrays;

import java.util.Scanner;

public class arrayOperations {
    
    public void createNewArray(int x1){
        int[] arrayLength = new int[x1];
        for (int count = 0;count < arrayLength.length; count++){

            System.out.println("assign a number to array number "+count+":");
            
            Scanner yeetScanner = new Scanner(System.in);
            
            arrayLength[count] = yeetScanner.nextInt();
        }
        
        System.out.println("I created a new array and it now has "+x1+" items in it");
        
        System.out.println("The array items and their values are listed below:");
        
        for (int yeet = 0; yeet < arrayLength.length; yeet++) {
            System.out.println( yeet + ": " + arrayLength[yeet]);
        }
    };
    
}