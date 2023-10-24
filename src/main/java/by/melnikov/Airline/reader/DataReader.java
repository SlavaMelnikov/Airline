package by.melnikov.Airline.reader;

import by.melnikov.Airline.exception.CustomException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReader {
    private static DataReader instance;

    public static DataReader getInstance() {
        if (instance == null) {
            instance = new DataReader();
        }
        return instance;
    }

    public List<String> fileDataReader(String pathToFile) throws CustomException {
        Path path = Path.of(pathToFile);
        if (!Files.exists(path)) {
            throw new CustomException("File not found in " + pathToFile);
        }
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new CustomException("The data is not correct", e);
        }
    }
}
