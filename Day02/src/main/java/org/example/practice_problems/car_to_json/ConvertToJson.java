package org.example.practice_problems.car_to_json;
import com.fasterxml.jackson.databind.ObjectMapper;

//ConvertToJson-->converts car object into Json format
public class ConvertToJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("Tesla", "Model 3", 2023);
        String json = objectMapper.writeValueAsString(car);
        //printing json
        System.out.println(json);
    }
}