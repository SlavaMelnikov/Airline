package by.melnikov.service;

import by.melnikov.entity.Airline;
import by.melnikov.entity.Flight;
import by.melnikov.exception.ServiceException;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface AirlineService {
    //todo changed void show... to List find...
    List<Flight> findAllFlights(Airline airline) throws ServiceException;
    List<Flight> findFlightsTo(Airline airline, String destination) throws ServiceException;
    List<Flight> findFlightsOn(Airline airline, DayOfWeek dayOfWeek) throws ServiceException;
    List<Flight> findFlightsOnAndAfter(Airline airline, DayOfWeek day, LocalTime time) throws ServiceException; //only this day and after time
    List<Flight> findAllFlightsAfter(Airline airline, DayOfWeek day, LocalTime time) throws ServiceException; //this day, after time and next days too
}
