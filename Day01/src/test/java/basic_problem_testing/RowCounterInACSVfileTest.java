package basic_problem_testing;
import org.example.basic_problems.read_and_count_rows_in_a_csv_file.RowCounterInACSVfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RowCounterInACSVfileTest {
    @Test
    public void countRowsTest(){
        int countRows=RowCounterInACSVfile.countRows("C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day01\\src\\main\\java\\org\\example\\basic_problems\\read_and_count_rows_in_a_csv_file\\Student.csv");
        int expectedRows=2;

        Assertions.assertEquals(expectedRows,countRows);
    }
}
