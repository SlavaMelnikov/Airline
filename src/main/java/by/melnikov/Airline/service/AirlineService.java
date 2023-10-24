package by.melnikov.Airline.service;

import by.melnikov.Airline.entity.Airline;
import by.melnikov.Airline.entity.Flight;
import by.melnikov.Airline.exception.CustomException;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface AirlineService {
    List<Flight> findAllFlights(Airline airline) throws CustomException;
    List<Flight> findFlightsTo(Airline airline, String destination) throws CustomException;
    List<Flight> findFlightsOn(Airline airline, DayOfWeek dayOfWeek) throws CustomException;
    List<Flight> findFlightsOnAndAfter(Airline airline, DayOfWeek day, LocalTime time) throws CustomException;
    List<Flight> findAllFlightsAfter(Airline airline, DayOfWeek day, LocalTime time) throws CustomException;
}
