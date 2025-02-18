package basic_problem_testing;
import org.example.basic_problems.read_a_csv_file_and_print_data.CSVFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVFileReaderTest {

    @Test
    public  void readCSVFileTest(){
        String filePath="C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\basic_problems\\read_a_csv_file_and_print_data\\student.csv";
        ArrayList<String>data=CSVFileReader.readCSVFile(filePath);
        ArrayList<String>expectedData=new ArrayList<>(Arrays.asList("[ID: 123,Name: Vinay,Age: 21,Marks:50]"));
        Assertions.assertEquals(expectedData,data);
    }
}
