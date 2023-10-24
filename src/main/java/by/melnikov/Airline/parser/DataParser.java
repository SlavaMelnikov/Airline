package by.melnikov.Airline.parser;

import by.melnikov.Airline.entity.Flight;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public List<Flight> parseData(List<String> lines) {
        List<Flight> flights = new ArrayList<>();
        for (String line : lines.subList(2, lines.size())) {
            String[] param = line.split("\\s+");
            long flightId = Long.parseLong(param[0]);
            String number = param[1];
            String destination = param[2];
            String plane = param[3];
            LocalTime time = LocalTime.parse(param[4]);
            DayOfWeek dayOfWeek = DayOfWeek.values()[Integer.parseInt(param[5]) - 1];
            flights.add(new Flight(flightId, number, destination, plane, time, dayOfWeek));
        }
        return flights;
    }
}
