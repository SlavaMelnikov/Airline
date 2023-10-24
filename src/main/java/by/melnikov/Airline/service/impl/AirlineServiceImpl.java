package by.melnikov.Airline.service.impl;

import by.melnikov.Airline.service.AirlineService;
import by.melnikov.Airline.entity.Airline;
import by.melnikov.Airline.entity.Flight;
import by.melnikov.Airline.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


public class AirlineServiceImpl implements AirlineService {
    private static final Logger logger = LogManager.getLogger();
    private static final AirlineServiceImpl instance = new AirlineServiceImpl();

    public static AirlineServiceImpl getInstance() { //todo
        return instance;
    }

    @Override
    public List<Flight> findAllFlights(Airline airline) throws CustomException {
        if (airline == null) {
            logger.error("airline is null");
            throw new CustomException("airline is null");
        }
        return airline.getFlights();
    }

    @Override
    public List<Flight> findFlightsTo(Airline airline, String destination) throws CustomException {
        if (airline == null) {
            logger.error("airline is null");
            throw new CustomException("airline is null");
        } else if (destination == null) {
            logger.error("airline is null");
            throw new CustomException("destination is null");
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
    public List<Flight> findFlightsOn(Airline airline, DayOfWeek dayOfWeek) throws CustomException {
        if (airline == null) {
            logger.error("airline is null");
            throw new CustomException("airline is null");
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
    public List<Flight> findFlightsOnAndAfter(Airline airline, DayOfWeek day, LocalTime time) throws CustomException {
        if (airline == null) {
            logger.error("airline is null");
            throw new CustomException("airline is null");
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
    public List<Flight> findAllFlightsAfter(Airline airline, DayOfWeek actualDay, LocalTime actualTime) throws CustomException {
        if (airline == null) {
            logger.error("airline is null");
            throw new CustomException("airline is null");
        }
        List<Flight> relevantFlights = new ArrayList<>();
        for (Flight flight : airline.getFlights()) {
            if (flight.getDepartureDay() == actualDay && flight.getDepartureTime().isAfter(actualTime)
                    || flight.getDepartureDay().ordinal() > actualDay.ordinal()) {
                relevantFlights.add(flight);
            }
        }
        Comparator<Flight> flightsDayAndTimeComparator = Comparator.comparing(Flight::getDepartureDay).thenComparing(Flight::getDepartureTime);
        relevantFlights.sort(flightsDayAndTimeComparator);
        return relevantFlights;
    }
}
