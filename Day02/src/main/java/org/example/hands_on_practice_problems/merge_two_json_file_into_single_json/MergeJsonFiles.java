package org.example.hands_on_practice_problems.merge_two_json_file_into_single_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
//MergeJsonFiles-->merges json data of two files into one
public class MergeJsonFiles {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        //Read JSON files
        JsonNode json1 = objectMapper.readTree(new File("C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day02\\src\\main\\java\\org\\example\\hands_on_practice_problems\\merge_two_json_file_into_single_json\\file1.json"));
        JsonNode json2 = objectMapper.readTree(new File("C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day02\\src\\main\\java\\org\\example\\hands_on_practice_problems\\merge_two_json_file_into_single_json\\file2.json"));

        JsonNode mergedNode;

        //Check if both JSONs are objects
        if (json1.isObject() && json2.isObject()) {
            ObjectNode mergedObject = objectMapper.createObjectNode();
            mergedObject.setAll((ObjectNode) json1);
            mergedObject.setAll((ObjectNode) json2);
            mergedNode = mergedObject;
        }
        //Check if both JSONs are arrays
        else if (json1.isArray() && json2.isArray()) {
            ArrayNode mergedArray = objectMapper.createArrayNode();
            mergedArray.addAll((ArrayNode) json1);
            mergedArray.addAll((ArrayNode) json2);
            mergedNode = mergedArray;
        }
        //Handle cases where one is an object and the other is an array
        else {
            ArrayNode mergedArray = objectMapper.createArrayNode();
            mergedArray.add(json1);
            mergedArray.add(json2);
            mergedNode = mergedArray;
        }

        //Print merged JSON
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode));
    }
}
