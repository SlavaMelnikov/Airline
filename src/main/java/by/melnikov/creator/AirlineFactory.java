package by.melnikov.creator;

import by.melnikov.entity.Airline;
import by.melnikov.entity.Flight;
import by.melnikov.exception.FileReaderException;
import by.melnikov.reader.DataReader;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AirlineFactory {
    //airline from file
    public static Airline create(String pathToFile) throws FileReaderException {
        DataReader reader = DataReader.getInstance();

        List<String> lines = reader.fileDataReader(pathToFile);
        List<String[]> data = reader.parseData(lines);

        List<Flight> allFlights = new ArrayList<>();
        for (String[] param : data) {
            long flightId = Long.parseLong(param[0]);
            String number = param[1];
            String destination = param[2];
            String plane = param[3];
            LocalTime time = LocalTime.parse(param[4]);
            DayOfWeek dayOfWeek = DayOfWeek.values()[Integer.parseInt(param[5]) - 1];
            allFlights.add(new Flight(flightId, number, destination, plane, time, dayOfWeek));
        }
        return new Airline(allFlights);
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
