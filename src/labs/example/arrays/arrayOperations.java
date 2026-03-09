package labs.example.arrays;

import java.util.Scanner;

public class arrayOperations {
    
    public void createNewArray(int x1){ //creates the first class with a intiger input
        int[] arrayLength = new int[x1]; //creates the first array with its lenght/slots being equal to the inputted amount
        for (int count = 0;count < arrayLength.length; count++){ //for the length of the array the use will be able to input a value into each slot

            System.out.println("assign a number to array number "+count+":");
            
            Scanner yeetScanner = new Scanner(System.in); //this is used to check for input
            
            arrayLength[count] = yeetScanner.nextInt(); //sets the slot of the loop count to the inputed number
        }
        displayArray(arrayLength); //a private class meant to be called at the end that has text about how long the array is and what each slot is
    }
    
    private void displayArray(int[] arrayLength){
        System.out.println("I created a new array and it now has " + arrayLength.length + " items in it");
        
        System.out.println("The array items and their values are listed below:");
        
        for (int yeet = 0; yeet < arrayLength.length; yeet++) { //this just repeats the slot number, and the given int
            System.out.println(yeet + ": " + arrayLength[yeet]);
        }
    }

    public static void sortArray(int[] arr){
        for (int count = 0; count < arr.length - 1; count++) { //bubble orginaizing system, really weird
            
            for (int i = 0; i < arr.length - 1 - count; i++) { //pretty much it goes through each slot and compares it to the next slot, and switches them if needed, and makes sure to not take to long for them
                
                if (arr[i] > arr[i + 1]) {
                    
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            System.out.println("this is the sorted array: ");
            
            }
        }
        for (int num : arr) { //prints the orginised array
            System.out.println(num);
        }
    }

    public static void getDaysAndMonths(){
        int[] daysInmonth = new int[12]; //creates an array with twelve slots that have the dates of each month in order
        daysInmonth[0] = 31; 
        daysInmonth[1] = 28; 
        daysInmonth[2] = 31; 
        daysInmonth[3] = 30; 
        daysInmonth[4] = 31; 
        daysInmonth[5] = 30; 
        daysInmonth[6] = 31; 
        daysInmonth[7] = 31; 
        daysInmonth[8] = 30; 
        daysInmonth[9] = 31; 
        daysInmonth[10] = 30; 
        daysInmonth[11] = 31; 

        String[] months = new String[12]; //creates an array that holds the name of each month in order
        months[0] = "January";
        months[1] = "February";
        months[2] = "March";
        months[3] = "April";
        months[4] = "May";
        months[5] = "June";
        months[6] = "July";
        months[7] = "August";
        months[8] = "September";
        months[9] = "October";
        months[10] = "November";
        months[11] = "December";

        System.out.println("Days in each month:");
        for (int i = 0; i < 12; i++) { //prints out each month with its correct number of days in order
            System.out.println(months[i] + ": " + daysInmonth[i]+" days");
        }
    };
}
