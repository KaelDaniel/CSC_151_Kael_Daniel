package labs.example.fileOperations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class logger {

    private static final String File_Path = "T:\\CSC_151_Kael_Daniel\\src\\labs\\example\\fileOperations\\";
    private static final String File_Name = File_Path + "files\\users.csv";
    private static final String Error_Logger_File = File_Path + "logs\\csv_error.log";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        openErrorLog();
    }

    public static void openErrorLog() throws FileNotFoundException, IOException{
        File csv_error = new File(Error_Logger_File); // creates a new file object with the path to the error log file
        try (BufferedReader reader = new BufferedReader(new FileReader(csv_error))){
            String error_line;
            while ((error_line = reader.readLine()) != null){
                System.out.println(error_line);
            }
        }
    };

//    public static void getCountOfErrorTypes(){
        
//    };

//    public static void getMemoryLimitExceededCount(){}
    
//    private static void getDiskSpaceErrorsWithIPAddress(file){}
}
