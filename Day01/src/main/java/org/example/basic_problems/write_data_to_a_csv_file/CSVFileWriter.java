package org.example.basic_problems.write_data_to_a_csv_file;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVFileWriter {
    public static Boolean writeCSVFile(String filePath, ArrayList<String[]>data){
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
        String fileName="C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\basic_problems\\write_data_to_a_csv_file\\Students.csv";
        ArrayList<String[]>data=new ArrayList<>(Arrays.asList(
                new String[]{"ID", "Name", "Department", "Salary"},
                new String[]{"123","Udit","CSE","40000"},
                new String[]{"234","Vinay","CSE","4000"},
                new String[]{"345","Shubhashree","AIML","400"},
                new String[]{"456","Utkarsh","CSE","40"}
        ));
        boolean result=writeCSVFile(fileName,data);
            System.out.println(result);
    }
}
