package org.example.hands_on_practice_problems.convert_json_to_xml_format;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

//ConvertJsonToXml-->Converts json object to XML
public class ConvertJsonToXml {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        // Read JSON file
        JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day02\\src\\main\\java\\org\\example\\hands_on_practice_problems\\convert_json_to_xml_format\\data.json"));

        // If the JSON is an array, wrap it inside a root element
        if (jsonNode.isArray()) {
            ObjectNode rootNode = objectMapper.createObjectNode();
            rootNode.set("Users", jsonNode); // Wrap in a single root element
            jsonNode = rootNode;
        }

        // Convert JSON to XML
        String xmlOutput = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        // Print XML
        System.out.println(xmlOutput);
    }
}

