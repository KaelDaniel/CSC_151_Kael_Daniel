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
        File csv_file = new File(File_Name);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(csv_file))){
        String line;
        reader.readLine();
            while ((line = reader.readLine() ) != null) {
                    
                String[] values = line.split(",");

                String name = values[0];
                int math = Integer.parseInt(values[1]);
                int sci = Integer.parseInt(values[2]);
                int ela = Integer.parseInt(values[3]);
                float average = (math+sci+ela)/3;
                System.out.println(name+": "+(average));


            }
        reader.close();
        }

    }


    private static void display_Error_Logs() throws FileNotFoundException, IOException{
        File csv_error = new File(Error_Logger_File);
        try (BufferedReader reader = new BufferedReader(new FileReader(csv_error))){
            String error_line;
            while ((error_line = reader.readLine()) != null){
                String[] error_reports = error_line.split(" [" + "] " + " - ");

                String dates = error_reports[0]
                String time = error_reports[1]
                String type = error_reports[2]
                String serial = error_reports[3]
                String info = error_reports[4]
            }
        }

    }
}
