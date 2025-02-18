package basic_problem_testing;

import org.example.basic_problems.write_data_to_a_csv_file.CSVFileWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CSVFileWriterTest {
    @Test
    public void writeCSVFileTest(){
        String filePath="C:\\\\Users\\\\udit0\\\\OneDrive\\\\Documents\\\\CapgeminiTraining\\\\Assignments\\\\Week5\\\\Day01\\\\src\\\\main\\\\java\\\\org\\\\example\\\\basic_problems\\\\write_data_to_a_csv_file\\\\Students.csv";
        ArrayList<String[]> data=new ArrayList<>(Arrays.asList(
                new String[]{"ID", "Name", "Department", "Salary"},
                new String[]{"123","Udit","CSE","40000"},
                new String[]{"234","Vinay","CSE","4000"},
                new String[]{"345","Shubhashree","AIML","400"},
                new String[]{"456","Utkarsh","CSE","40"}
        ));
        boolean result=CSVFileWriter.writeCSVFile(filePath,data);
        Assertions.assertTrue(result);
    }
}
