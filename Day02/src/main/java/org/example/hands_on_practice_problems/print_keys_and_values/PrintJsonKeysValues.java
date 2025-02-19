package org.example.hands_on_practice_problems.print_keys_and_values;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
//PrintJsonKeysValues-->Prints keys and values of a json data file
public class PrintJsonKeysValues {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day02\\src\\main\\java\\org\\example\\hands_on_practice_problems\\print_keys_and_values\\data.json"));

            for (JsonNode node : rootNode) {
                Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> field = fields.next();
                    System.out.println(field.getKey() + ": " + field.getValue());
                }
                System.out.println("----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
