package org.example.intermediate_problem.search_for_a_record_in_csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class RecordFinder {
    //method reads and return data of a CSV file in String with given name constraint
    public static String readCSVFile(String filePath,String name){
        String record="";
        //Handling file exceptions
        try(CSVReader reader=new CSVReader(new FileReader(filePath))){
            String[] nextLine;
            String obj = "";
            while ((nextLine = reader.readNext()) != null) {
                if(name.equals(nextLine[1])) {
                    obj = obj + ("ID: " + nextLine[0] + ",Name: " + nextLine[1] + ",Age: " + nextLine[2] + ",Salary" + nextLine[3]);
                    record=obj;
                }
            }
        }catch (CsvValidationException e){
            System.out.println("CSV file not found");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return record;
    }

    public static void main(String[] args) {
        //File path of the given csv file
        String filePath="C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\intermediate_problem\\search_for_a_record_in_csv\\employees.csv";
        //method call for readCSVFile
        String data=readCSVFile(filePath,"Vinay");

        //Printing data
        System.out.println(data);
    }
}
