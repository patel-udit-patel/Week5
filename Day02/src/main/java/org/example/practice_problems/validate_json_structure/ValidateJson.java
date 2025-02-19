package org.example.practice_problems.validate_json_structure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Udit Patel\",\"age\":21}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            if (jsonNode.has("name") && jsonNode.has("age")) {
                System.out.println("Valid JSON structure");
            } else {
                System.out.println("Invalid JSON structure");
            }
        } catch (Exception e) {
            System.out.println("Invalid JSON format");
        }
    }
}
