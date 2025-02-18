package org.example.intermediate_problem.modify_a_csv_file;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;

//UpdateItSalary->Modify the records of CSV files
public class UpdateItSalary {
    //method updates the salary in the records
    public static void updateSalary(String inputFile, String outputFile) {
        List<String[]> records = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            String[] header = reader.readNext();
            if (header != null) {
                records.add(header);
            }

            String[] row;
            while ((row = reader.readNext()) != null) {
                if (row[1].equals("IT")) { // Assuming 2nd column is Department
                    double salary = Double.parseDouble(row[2]); // Assuming 3rd column is Salary
                    salary *= 1.10;
                    row[2] = String.format("%.2f", salary);
                }
                records.add(row);
            }

            writer.writeAll(records);
            System.out.println("Updated salaries saved to " + outputFile);

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }catch (CsvValidationException e){
            System.out.println("File is not a CSV file");
        }
    }
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\intermediate_problem\\modify_a_csv_file\\employees.csv";
        String outputFile = "C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\intermediate_problem\\modify_a_csv_file\\updated_employees.csv";

        updateSalary(inputFile, outputFile);
    }
}

