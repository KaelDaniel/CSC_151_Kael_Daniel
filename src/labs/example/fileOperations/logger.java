package labs.example.fileOperations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class logger {

    private static final String File_Path = "T:\\CSC_151_Kael_Daniel\\src\\labs\\example\\fileOperations\\";
    private static final String Error_Logger_File = File_Path + "logs\\csv_error.log";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (BufferedReader file1 = openErrorLog()) {
            getCountOfErrorTypes(file1);
        }
    }

    public static BufferedReader openErrorLog() throws FileNotFoundException, IOException{
        File csv_error = new File(Error_Logger_File); // creates a new file object with the path to the error log file
        return new BufferedReader(new FileReader(csv_error));
    }

    public static void getCountOfErrorTypes(BufferedReader reader) throws IOException {
        List<String> logLevels = new ArrayList<>();
        String error_Line;
        while ((error_Line = reader.readLine()) != null) {
            String[] error_count = error_Line.split(" ");
            if (error_count.length > 2) {
                logLevels.add(error_count[2]);
            }
        }
        // Count the occurrences of each log level
        int error_Counter = 0;
        int warn_Counter = 0;
        int info_Counter = 0;

        for (String level : logLevels) {
            if (level.equals("[ERROR]")) {
                error_Counter++;

            } 
            else if (level.equals("[WARN]")) {
                warn_Counter++;
            } 
            else if (level.equals("[INFO]")) {
                info_Counter++;

            }
        }

        System.out.println("[ERROR]: " + error_Counter);
        System.out.println("[WARN]: " + warn_Counter);
        System.out.println("[INFO]: " + info_Counter);
    }

//    public static void getMemoryLimitExceededCount(file2){}
    
//    private static void getDiskSpaceErrorsWithIPAddress(){}
}
