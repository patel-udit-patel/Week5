package org.example.hands_on_practice_problems.convert_csv_data_into_json;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;

public class ConvertCsvToJson {
    public static void main(String[] args) throws Exception {
        File csvFile = new File("C:\\Users\\udit0\\OneDrive\\Documents\\CapgeminiTraining\\Assignments\\Week5\\Day02\\src\\main\\java\\org\\example\\hands_on_practice_problems\\convert_csv_data_into_json\\data.csv");
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();

        MappingIterator<Object> iterator = csvMapper.readerFor(Object.class).with(csvSchema).readValues(csvFile);
        List<Object> data = iterator.readAll();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);

        System.out.println(jsonOutput);
    }
}
