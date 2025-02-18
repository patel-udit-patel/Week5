package org.example.basic_problems.read_and_count_rows_in_a_csv_file;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class RowCounterInACSVfile {
    //method reads and return count of rows of a CSV file
    public static int countRows(String filePath){
        int countRows=0;
        //Handling file exceptions
        try(CSVReader reader=new CSVReader(new FileReader(filePath))){
            String[] nextLine;
            while((nextLine= reader.readNext())!=null){
//                System.out.println("ID: "+nextLine[0]+ ",Name: "+nextLine[1]+",Age: "+nextLine[2]+",Marks:"+nextLine[3]);
              countRows++;
            }
        }catch (CsvValidationException e){
            System.out.println("CSV file not found");
        }
        catch (IOException e){
            e.printStackTrace();
        }
            return countRows;
    }

    public static void main(String[] args) {
        //Path of file to read
        String filePath="C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\basic_problems\\read_and_count_rows_in_a_csv_file\\Student.csv";
        System.out.println(countRows(filePath));
    }
}
