package by.melnikov.creator;

import by.melnikov.entity.Airline;
import by.melnikov.entity.Flight;

import java.util.ArrayList;
import java.util.List;

public class AirlineFactory {
    //airline from file
    public static Airline createAirline(String pathToFile) {
        List<String> lines = FactoryUtils.readFromFile(pathToFile);
        List<String[]> data = FactoryUtils.extractData(lines);
        List<Flight> allFlights = FactoryUtils.createSchedule(data);
        return new Airline(allFlights);
    }

    //custom airline
    public static Airline createAirline(List<Flight> flights) {
        return new Airline(flights);
    }

    //empty airline
    public static Airline createAirline() {
        return new Airline(new ArrayList<>());
    }
}
