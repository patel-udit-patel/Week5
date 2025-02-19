package org.example.practice_problems.merge_two_json_objects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

//MergeJson-->merges two json objects into one
public class MergeJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String json1 = "{\"name\":\"Alice\",\"age\":25}";
        String json2 = "{\"city\":\"New York\",\"email\":\"alice@example.com\"}";

        JsonNode node1 = objectMapper.readTree(json1);
        JsonNode node2 = objectMapper.readTree(json2);

        ObjectNode mergedNode = objectMapper.createObjectNode();
        mergedNode.setAll((ObjectNode) node1);
        mergedNode.setAll((ObjectNode) node2);

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode));
    }
}
