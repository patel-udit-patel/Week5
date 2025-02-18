package org.example.basic_problems.write_data_to_a_csv_file;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//CSVFileWriter-->Writes CSV data in CSV file
public class CSVFileWriter {
    //method writes data of given Arraylist in a CSV file
    public static Boolean writeCSVFile(String filePath, ArrayList<String[]>data){
        //handling file exceptions
        try(CSVWriter writer =new CSVWriter(new FileWriter(filePath))){
            for(String[] row:data){
                writer.writeNext(row);
            }
            return true;
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        //File path for writing data
        String filePath="C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\basic_problems\\write_data_to_a_csv_file\\Students.csv";
        ArrayList<String[]>data=new ArrayList<>(Arrays.asList(
                new String[]{"ID", "Name", "Department", "Salary"},
                new String[]{"123","Udit","CSE","40000"},
                new String[]{"234","Vinay","CSE","4000"},
                new String[]{"345","Shubhashree","AIML","400"},
                new String[]{"456","Utkarsh","CSE","40"}
        ));
        boolean result=writeCSVFile(filePath,data);
            System.out.println(result);
    }
}
