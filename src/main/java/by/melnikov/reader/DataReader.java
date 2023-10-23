package by.melnikov.reader;

import by.melnikov.exception.FileReaderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static DataReader instance;

    public static DataReader getInstance() {
        if (instance == null) {
            instance = new DataReader();
        }
        return instance;
    }

    public List<String> fileDataReader(String pathToFile) throws FileReaderException { //todo
        Path path = Path.of(pathToFile);
        if (!Files.exists(path)) {
            throw new FileReaderException("File not found");
        } else {
            try {
                return Files.readAllLines(path);
            } catch (IOException e) {
                throw new FileReaderException("The data is not correct", e);
            }
        }
    }

    public List<String[]> parseData(List<String> lines) {
        List<String[]> data = new ArrayList<>();
        for (String line : lines) {
            data.add(line.split("\\s+"));
        }
        return data;
    }
}
