package labs.example.fileOperations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileOperator {
    
    private static final String File_Path = "T:\\CSC_151_Kael_Daniel\\src\\labs\\example\\fileOperations\\";
    private static final String File_Name = File_Path + "files\\users.csv";
    private static final String Error_Logger_File = File_Path + "logs\\csv_error.log";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        open_CSV_File();
        display_Error_Logs();

    }

    private static void open_CSV_File() throws FileNotFoundException, IOException{
        File csv_file = new File(File_Name); //makes a new file object with the path to the csv file
        
        try (BufferedReader reader = new BufferedReader(new FileReader(csv_file))){ //makes a new buffered reader object that reads the csv file, the try with resources statement automatically closes the reader when done
        String line; // declares a string variable to hold each line of the csv file as it is read
        reader.readLine(); // reads the first line of the csv file, which is typically the header row, and discards it since we don't need it for processing the data
            while ((line = reader.readLine() ) != null) { // reads each subsequent line of the csv file until the end of the file is reached, storing each line in the variable "line"
                    
                String[] values = line.split(","); // splits the line into an array of strings using the comma as a delimiter, since csv files use commas to separate values, and stores the resulting array in the variable "values"

                String name = values[0]; 
                int math = Integer.parseInt(values[1]);
                int sci = Integer.parseInt(values[2]);
                int ela = Integer.parseInt(values[3]);
                float average = (math+sci+ela)/3;
                System.out.println(name+": "+(average)); 
                // prints the name of the student and their average score in math, science, and ela to the console as in the last couple lines the different values were able to extract from the csv file are stored in variables


            }
        reader.close();}
    }


    private static void display_Error_Logs() throws FileNotFoundException, IOException{ 
        File csv_error = new File(Error_Logger_File); // creates a new file object with the path to the error log file
        try (BufferedReader reader = new BufferedReader(new FileReader(csv_error))){ // uses a buffered reader to read the contents of the error log file
            String error_line;
            while ((error_line = reader.readLine()) != null){ // reads each line of the error log file until the end of the file is reached, storing each line in the variable "error_line"
                String[] error_reports = error_line.split(" "); // splits each line of the error log file into an array of strings using a space as the split location

                String dates = error_reports[0];
                String time = error_reports[1];
                String error_type = error_reports[2];
                String error_version = error_reports[3];

                System.out.println(dates+" "+time+": "+error_type+" "+error_version); //prints out the data of the error logs to make searching easier 
            }
        }

    }
}
