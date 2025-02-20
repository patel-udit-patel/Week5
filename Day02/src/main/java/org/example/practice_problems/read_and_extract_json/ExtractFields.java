package org.example.practice_problems.read_and_extract_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ExtractFields {
    public static void main(String[] args) {
        try {
            // Initialize ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into JsonNode
            JsonNode rootNode = objectMapper.readTree(new File("C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day02\\src\\main\\java\\org\\example\\practice_problems\\read_and_extract_json\\data.json"));

            // Iterate through the JSON array and extract name & email
            for (JsonNode node : rootNode) {
                String name = node.get("name").asText();
                String email = node.get("email").asText();
                System.out.println("Name: " + name + ", Email: " + email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

