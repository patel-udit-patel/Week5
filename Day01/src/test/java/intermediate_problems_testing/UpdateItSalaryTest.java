package intermediate_problems_testing;
import org.example.intermediate_problem.modify_a_csv_file.UpdateItSalary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.*;

public class UpdateItSalaryTest { @Test
    void testUpdateSalary() throws IOException {
        String testInput = "test_employees.csv";
        String testOutput = "test_updated_employees.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testInput))) {
            writer.write("Name,Department,Salary\n");
            writer.write("John,IT,50000\n");
            writer.write("Jane,HR,45000\n");
            writer.write("Bob,IT,60000\n");
        }

        UpdateItSalary.updateSalary(testInput, testOutput);

        try (BufferedReader reader = new BufferedReader(new FileReader(testOutput))) {
            reader.readLine();
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            String line3 = reader.readLine();

            Assertions.assertTrue(line1.contains("55000.00")); // 10% increase for IT
            Assertions.assertTrue(line2.contains("45000")); // HR salary unchanged
            Assertions.assertTrue(line3.contains("66000.00")); // 10% increase for IT
        }
    }
}