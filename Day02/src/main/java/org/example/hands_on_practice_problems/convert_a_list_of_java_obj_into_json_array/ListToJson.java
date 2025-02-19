package org.example.hands_on_practice_problems.convert_a_list_of_java_obj_into_json_array;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.practice_problems.convert_a_list_of_java_object_into_json.ListToJsonArray;

import java.util.Arrays;
import java.util.List;
//ListToJson-->Converts List of java objects into json
public class ListToJson {
    public static void main(String[] args) throws Exception {
        List<User> users = Arrays.asList(new User("Udit", 21), new User("Vinay", 21));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);

        System.out.println(jsonArray);
    }
}