package org.example.hands_on_practice_problems.generate_json_from_database;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenerateJsonFromDB {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:h2:mem:testdb";

        try (Connection conn = DriverManager.getConnection(url, "sa", "");
             Statement stmt = conn.createStatement()) {

            //Create Table
            stmt.execute("CREATE TABLE Student (Name VARCHAR(50),email VARCHAR(50),Age INTEGER)");

            //insert Sample Data
            stmt.execute("INSERT INTO Student VALUES ('Udit Patel', 'udit0428t@gmail.com',21)");
            stmt.execute("INSERT INTO Student VALUES ('Vinay Jadaun','vinay@gmail.com',22)");

            ResultSet rs = stmt.executeQuery("SELECT name, email, age FROM users");

            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(rs.getString("name"), rs.getString("email"), rs.getInt("age")));
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);

            System.out.println(jsonOutput);
        }

    }
}