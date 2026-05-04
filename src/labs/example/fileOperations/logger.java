package labs.example.fileOperations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class logger {
    // Utility function to close a BufferedReader safely
    public static void closeFile(BufferedReader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static final String File_Path = "T:\\CSC_151_Kael_Daniel\\src\\labs\\example\\fileOperations\\";
    private static final String Error_Logger_File = File_Path + "logs\\csv_error.log";
    private static final String Api_Logger_File = File_Path + "logs\\api_error.log";
    private static final String Http_Logger_File = File_Path + "logs\\http_access.log";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader errorLogReader = openErrorLog(); 
        getCountOfErrorTypes(errorLogReader); 

        BufferedReader memoryLimitReader = openErrorLog(); 
        getMemoryLimitExceededCount(memoryLimitReader); 

        BufferedReader diskSpaceReader = openErrorLog(); 
        getDiskSpaceErrorsWithIPAddress(diskSpaceReader); 

        BufferedReader apiErrorReader = openErrorLog(openHttpLog()); 
        getGMOffset(apiErrorReader); 
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
    
    public static BufferedReader openErrorlogs() throws FileNotFoundException, IOException{
        File Api_Error = new File(Api_Logger_File);
        return new BufferedReader(new FileReader(Api_Error));
    };

    public static BufferedReader openHttpLog() throws FileNotFoundException, IOException{
        File Http_Error = new File(Http_Logger_File);
        return new BufferedReader(new FileReader(Http_Error));
    }

    private static void getDiskSpaceErrorsWithIPAddress(BufferedReader file3){
        String error_Line;
        int lineNumber = 0; // Initialize line number counter
        boolean foundError = false; // Flag to check if any error is found
        try {
            while ((error_Line = file3.readLine()) != null) {
                if (error_Line.contains("Disk space")) { // Check if the line contains "Disk space"
                    String[] parts = error_Line.split("-"); // Split the line by the "-" character
                    if (parts.length >= 2) { // Check if the split resulted in at least 2 parts
                        String ipAddress = parts[2].trim(); // Get close to the IP address but requires a bit more cutting
                        String[] secondSplit = ipAddress.split(" "); // Split the IP address part by spaces to isolate the IP address
                        System.out.println("disk space error on line " + lineNumber + " for IP Address: " + secondSplit[3]); // end result is printed
                        foundError = true; // Set flag to true if an error is found
                    }    
                }
                lineNumber++; // and goes to the next line
            }
            if (!foundError) { // Print message if no errors were found
                System.out.println("No disk space errors found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedReader openErrorLog(BufferedReader HTTP_Access) {
        try {
            return openErrorlogs(); // Call the method to open the error logs
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if an exception occurs
        }
    }

    private static void getGMOffset(BufferedReader file) {
        String error_line;
        int positiveCount = 0; // Counter for +0000
        int negativeCount = 0; // Counter for -0500
        try {
            while ((error_line = file.readLine()) != null) {

                if (error_line.contains("+0000")) { 
                        positiveCount++; // Increment positive count
                    } else if (error_line.contains("-0500")) {
                        negativeCount++; // Increment negative count
                    }
                }
            }catch (IOException e) {
            e.printStackTrace();
        }
            System.out.println("Positive GMOffset count: " + positiveCount); // Print count of +0000
            System.out.println("Negative GMOffset count: " + negativeCount); // Print count of -0500
        } 
    }
