package labs.example.fileOperations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class logger {

    private static final String File_Path = "T:\\CSC_151_Kael_Daniel\\src\\labs\\example\\fileOperations\\";
    private static final String Error_Logger_File = File_Path + "logs\\csv_error.log";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (BufferedReader file1 = openErrorLog()) { // creates a buffered 
            getCountOfErrorTypes(file1);
        }
        try (BufferedReader file2 = openErrorLog()) {
            getMemoryLimitExceededCount(file2);
        }
    }

    public static BufferedReader openErrorLog() throws FileNotFoundException, IOException{
        File csv_error = new File(Error_Logger_File); // creates a new file object with the path to the error log file
        return new BufferedReader(new FileReader(csv_error)); //returns a buffered reader object that reads from the error log file
    }

    public static void getCountOfErrorTypes(BufferedReader reader) throws IOException {
        List<String> logLevels = new ArrayList<>(); // creates a new list to store the log levels found in the error log file
        String error_Line;
        while ((error_Line = reader.readLine()) != null) { // reads each line of the error log file until reaching the end
            String[] error_count = error_Line.split(" ");
            if (error_count.length > 2) { // checks if the line has at least 3 splits
                logLevels.add(error_count[2]); // adds the 3rd section to the array list, which would be the error types
            }
        }
        // sets up the counters for error, warn, and info
        int error_Counter = 0;
        int warn_Counter = 0;
        int info_Counter = 0;

        for (String level : logLevels) {
            if (level.equals("[ERROR]")) {
                error_Counter++; //adds a count for every error

            } 
            else if (level.equals("[WARN]")) {
                warn_Counter++; //adds a count for every warning
            } 
            else if (level.equals("[INFO]")) {
                info_Counter++; //adds a count for every info

            }
        }

        System.out.println("[ERROR]: " + error_Counter); //prints out the final count
        System.out.println("[WARN]: " + warn_Counter);
        System.out.println("[INFO]: " + info_Counter);
        reader.close(); // closes the BufferedReader
    }

    public static void getMemoryLimitExceededCount(BufferedReader file2){
        int memory_Limit = 0; // sets up a counter for the number of times the memory limit was exceeded
        String error_Line;
        try {
            while ((error_Line = file2.readLine()) != null) { // reads each line of the error log file until reaching the end

                if (error_Line.contains("Memory limit exceeded")) { // checks if the line contains "Memory limit exceeded"

                    memory_Limit++; // adds a count for every time the memory limit was exceeded
                }
            }

            System.out.println("Memory Limit Exceeded Count: " + memory_Limit); // prints out the final count

            file2.close(); // closes the BufferedReader
        } 
        catch (IOException e) {
            e.printStackTrace(); // prints the stack trace if an IOException occurs
        }
    }
    
//    private static void getDiskSpaceErrorsWithIPAddress(){}
}
