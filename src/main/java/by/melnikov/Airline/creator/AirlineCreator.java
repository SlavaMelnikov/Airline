package by.melnikov.Airline.creator;

import by.melnikov.Airline.entity.Airline;
import by.melnikov.Airline.entity.Flight;
import by.melnikov.Airline.exception.CustomException;
import by.melnikov.Airline.parser.DataParser;
import by.melnikov.Airline.reader.DataReader;

import java.util.ArrayList;
import java.util.List;

public class AirlineCreator {
    //airline from file
    public static Airline create(String pathToFile) throws CustomException {
        DataReader reader = DataReader.getInstance();
        DataParser parser = new DataParser();
        List<String> lines = reader.fileDataReader(pathToFile);
        List<Flight> flights = parser.parseData(lines);
        return new Airline(flights);
    }

    //custom airline
    public static Airline create(List<Flight> flights) {
        return new Airline(flights);
    }

    //empty airline
    public static Airline create() {
        return new Airline(new ArrayList<>());
    }
}
