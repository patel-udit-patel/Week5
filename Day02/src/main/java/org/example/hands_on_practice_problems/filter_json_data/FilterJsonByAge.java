package org.example.hands_on_practice_problems.filter_json_data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

//FilterJsonByAge->filters json data by age constraint
public class FilterJsonByAge {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File("C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day02\\src\\main\\java\\org\\example\\hands_on_practice_problems\\filter_json_data\\data.json"));

        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node);
            }
        }
    }
}
