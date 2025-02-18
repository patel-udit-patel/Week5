package org.example.intermediate_problem.sort_csv_by_a_column;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortRecordsBySalary {

    public static void sortAndPrintTopSalaries(String inputFile) {
        List<String[]> records = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFile))) {
            String[] header = reader.readNext();
            if (header != null) {
                records.add(header);
            }

            String[] row;
            while ((row = reader.readNext()) != null) {
                records.add(row);
            }

            records.sort((r1, r2) -> Double.compare(Double.parseDouble(r2[2]), Double.parseDouble(r1[2])));

            System.out.println("Top 5 highest-paid employees:");
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(Arrays.toString(records.get(i)));
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }catch (CsvValidationException e){
            System.out.println("CSV file not found");
        }
    }
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\intermediate_problem\\sort_csv_by_a_column\\employees.csv";

        sortAndPrintTopSalaries(inputFile);
    }
}
