package org.example.practice_problems.student_to_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

public class StudentToJson {
    public static void main(String[] args) {
        try {
            // Create a Student object
            Student student = new Student("Udit Patel", 21, Arrays.asList("Math", "Physics", "Computer Science"));

            // Convert to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);

            // Print the JSON output
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

