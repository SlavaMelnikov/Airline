package by.melnikov.service;

import by.melnikov.entity.Airline;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface AirlineService {
    void showAllFlights(Airline airline);
    void showAllFlightsTo(Airline airline, String destination);
    void showAllFlightsOn(Airline airline, DayOfWeek dayOfWeek);
    void showAllFlightsOnAndAfter(Airline airline, DayOfWeek dayOfWeek, LocalTime time);
    void showActualSchedule(Airline airline, DayOfWeek day, LocalTime time);
}
