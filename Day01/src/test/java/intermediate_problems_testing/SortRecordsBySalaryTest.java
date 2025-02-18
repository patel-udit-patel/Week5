package intermediate_problems_testing;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import org.example.intermediate_problem.sort_csv_by_a_column.SortRecordsBySalary;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortRecordsBySalaryTest {
    @Test
    void testSortAndPrintTopSalaries() throws IOException {
        String testInput = "C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\intermediate_problem\\sort_csv_by_a_column\\employees.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testInput))) {
            writer.write("Name,Department,Salary\n");
            writer.write("Alice,IT,90000\n");
            writer.write("Bob,HR,85000\n");
            writer.write("Charlie,Finance,95000\n");
            writer.write("David,IT,92000\n");
            writer.write("Eve,Marketing,88000\n");
            writer.write("Frank,Sales,87000\n");
        }

        SortRecordsBySalary.sortAndPrintTopSalaries(testInput);

        try (CSVReader reader = new CSVReader(new FileReader(testInput))) {
            reader.readNext(); // Skip header
            List<String[]> sortedRecords = new ArrayList<>();
            String[] row;
            while ((row = reader.readNext()) != null) {
                sortedRecords.add(row);
            }

            assertEquals("Charlie", sortedRecords.get(0)[0]); // Highest salary
            assertEquals("David", sortedRecords.get(1)[0]);
            assertEquals("Alice", sortedRecords.get(2)[0]);
            assertEquals("Eve", sortedRecords.get(3)[0]);
            assertEquals("Frank", sortedRecords.get(4)[0]);
        }catch (CsvValidationException e){
            e.printStackTrace();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

}
