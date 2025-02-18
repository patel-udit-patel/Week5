package intermediate_problems_testing;

import org.example.intermediate_problem.search_for_a_record_in_csv.RecordFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecordFinderTesting {
    @Test
    public void readCSVFile(){
        String filePath="C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\intermediate_problem\\search_for_a_record_in_csv\\employees.csv";
        String ans=RecordFinder.readCSVFile(filePath,"Vinay");
        String expected="ID: 123,Name: Vinay,Age: 21,Salary400000";

        Assertions.assertEquals(ans,expected);
    }
}
