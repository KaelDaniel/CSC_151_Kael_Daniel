package labs.example.fileOperations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileOperator {
    
    private static final String File_Path = "T:\\CSC_151\\src\\labs\\example\\fileOperations\\";
    private static final String File_Name = File_Path + "files\\users.csv";
    private static final String Error_Logger_File = File_Path + "logs\\csv_error.log";

    public static void main(String[] args) {
        open_CSV_File();
    }

    private static void open_CSV_File(){
        File csv_file = new File(File_Name);
        File csv_error = new File(Error_Logger_File);
        try (BufferedReader reader = new BufferedReader(new FileReader(csv_file))){;
        String[] line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");

            String name = values[0];
            int math = Integer.parseInt(values[1]);
            int sci = Integer.parseInt(values[2]);
            int ela = Integer.parseInt(values[3]);
            
        }
        }
    }
}
