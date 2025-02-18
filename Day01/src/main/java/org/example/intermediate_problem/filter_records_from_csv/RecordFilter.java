package org.example.intermediate_problem.filter_records_from_csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//RecordFilter-->reads filtered data from CSV file and prints on console
public class RecordFilter {
    //method reads and return data of a CSV file in String with given filter
    public static ArrayList<String> readCSVFile(String filePath) {
        ArrayList<String> data = new ArrayList<>();
        //Handling file exceptions
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext();
            String obj = "";
            while ((nextLine = reader.readNext()) != null) {
                if(Integer.parseInt(nextLine[3])>80) {
                    obj = obj + ("ID: " + nextLine[0] + ",Name: " + nextLine[1] + ",Age: " + nextLine[2] + ",Marks:" + nextLine[3]);
                    data.add(obj);
                }
            }
        } catch (CsvValidationException e) {
            System.out.println("CSV file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static void main(String[] args) {
        //File path of the given csv file
        String filePath="C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\intermediate_problem\\filter_records_from_csv\\student.csv";
        //method call for readCSVFile
        ArrayList<String>data=readCSVFile(filePath);

        //Printing data
        System.out.println(data);
    }
}
