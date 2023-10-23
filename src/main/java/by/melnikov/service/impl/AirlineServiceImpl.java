package by.melnikov.service.impl;

import by.melnikov.entity.Airline;
import by.melnikov.entity.Flight;
import by.melnikov.exception.ServiceException;
import by.melnikov.service.AirlineService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


public class AirlineServiceImpl implements AirlineService {
    private static Logger logger = LogManager.getLogger();
    private static AirlineServiceImpl instance = new AirlineServiceImpl();

    public static AirlineServiceImpl getInstance() { //todo
        return instance;
    }
    @Override
    public List<Flight> findAllFlights(Airline airline) throws ServiceException {
        if (airline == null) {
            logger.error("airline is null"); //fixme right or no?
            throw new ServiceException("airline is null");
        }
        return airline.getFlights();
    }

    @Override
    public List<Flight> findFlightsTo(Airline airline, String destination) throws ServiceException {
        if (airline == null) {
            throw new ServiceException("airline is null");
        } else if (destination == null) {
            throw new ServiceException("destination is null");
        }
        List<Flight> relevantFlights = new ArrayList<>();
        for (Flight flight : airline.getFlights()) {
            if (flight.getDestination() .equalsIgnoreCase(destination)) {
                relevantFlights.add(flight);
            }
        }
        return relevantFlights;
    }

    @Override
    public List<Flight> findFlightsOn(Airline airline, DayOfWeek dayOfWeek) throws ServiceException {
        if (airline == null) {
            throw new ServiceException("airline is null");
        }
        List<Flight> relevantFlights = new ArrayList<>();
        for (Flight flight : airline.getFlights()) {
            if (flight.getDepartureDay() == dayOfWeek) {
                relevantFlights.add(flight);
            }
        }
        return relevantFlights;
    }

    @Override
    public List<Flight> findFlightsOnAndAfter(Airline airline, DayOfWeek day, LocalTime time) throws ServiceException {
        if (airline == null) {
            throw new ServiceException("airline is null");
        }
        List<Flight> relevantFlights = new ArrayList<>();
        for (Flight flight : airline.getFlights()) {
            if (flight.getDepartureDay() == day && flight.getDepartureTime().isAfter(time)) {
                relevantFlights.add(flight);
            }
        }
        return relevantFlights;
    }

    @Override
    public List<Flight> findAllFlightsAfter(Airline airline, DayOfWeek actualDay, LocalTime actualTime) throws ServiceException {
        if (airline == null) {
            throw new ServiceException("airline is null");
        }
        List<Flight> relevantFlights = new ArrayList<>();
        for (Flight flight : airline.getFlights()) {
            if (flight.getDepartureDay() == actualDay && flight.getDepartureTime().isAfter(actualTime)
                    || flight.getDepartureDay().ordinal() > actualDay.ordinal()) {
                relevantFlights.add(flight);
            }
        }
        Comparator<Flight> flightsDayAndTimeComparator = Comparator.comparing(Flight::getDepartureDay).thenComparing(Flight::getDepartureTime); //todo
        relevantFlights.sort(flightsDayAndTimeComparator); // or Collections.sort(list, comparator)?
        return relevantFlights;
    }
}
