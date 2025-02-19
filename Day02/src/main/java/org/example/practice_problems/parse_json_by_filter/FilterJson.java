package org.example.practice_problems.parse_json_by_filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
//FilterJson-->filters the record where age >25
public class FilterJson {
    public static void main(String[] args) throws Exception {
        String jsonArray = "[{\"name\":\"Udit\",\"age\":31},{\"name\":\"Vinay\",\"age\":32},{\"name\":\"Shubh\",\"age\":23}]";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonArray);

        List<JsonNode> filteredList = new ArrayList<>();
        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                filteredList.add(node);
            }
        }

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredList));
    }
}
