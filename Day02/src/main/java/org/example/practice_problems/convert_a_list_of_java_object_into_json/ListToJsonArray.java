package org.example.practice_problems.convert_a_list_of_java_object_into_json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
//ListToJsonArray->converts list of java objects into json
public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        List<Student> students = Arrays.asList(
            new Student("Vinay", 22),
            new Student("Udit", 24)
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writeValueAsString(students);
        System.out.println(jsonArray);
    }
}