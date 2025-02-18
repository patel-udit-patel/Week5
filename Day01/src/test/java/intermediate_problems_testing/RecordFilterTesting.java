package intermediate_problems_testing;

import org.example.intermediate_problem.filter_records_from_csv.RecordFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RecordFilterTesting {
    @Test
    public void readCSVFileTest(){
        String filePath="C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\intermediate_problem\\filter_records_from_csv\\student.csv";
        ArrayList<String>ans = RecordFilter.readCSVFile(filePath);
        ArrayList<String>expected=new ArrayList<>(Arrays.asList("ID: 134,Name: Udit,Age: 21,Marks:81"));

        Assertions.assertEquals(expected,ans);
    }
}
