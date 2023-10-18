package by.melnikov.service;

import by.melnikov.entity.Airline;
import by.melnikov.entity.Flight;
import static by.melnikov.main.Main.logger;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AirlineServiceImpl implements AirlineService {
    @Override
    public void showAllFlights(Airline airline) {
        for (Flight flight : airline.getAllFlights()) {
            logger.info(flight);
        }
    }

    @Override
    public void showAllFlightsTo(Airline airline, String destination) {
        for (Flight flight : airline.getAllFlights()) {
            if (flight.getDestination().equalsIgnoreCase(destination)) {
                logger.info(flight);
            }
        }
    }

    @Override
    public void showAllFlightsOn(Airline airline, DayOfWeek dayOfWeek) {
        for (Flight flight : airline.getAllFlights()) {
            if (flight.getDepartureDay() == dayOfWeek) {
                logger.info(flight);
            }
        }
    }

    @Override
    public void showAllFlightsOnAndAfter(Airline airline, DayOfWeek dayOfWeek, LocalTime time) {
        for (Flight flight : airline.getAllFlights()) {
            if (flight.getDepartureDay() == dayOfWeek && flight.getDepartureTime().isAfter(time)) {
                logger.info(flight);
            }
        }
    }

    @Override
    public void showActualSchedule(Airline airline, DayOfWeek actualDay, LocalTime actualTime) {
        List<Flight> upcomingFlights = new ArrayList<>();
        for (Flight flight : airline.getAllFlights()) {
            if (flight.getDepartureDay() == actualDay && flight.getDepartureTime().isAfter(actualTime)
                    || flight.getDepartureDay().ordinal() > actualDay.ordinal()) {
                upcomingFlights.add(flight);
            }
        }
        Comparator<Flight> flightsDayAndTimeComparator = Comparator.comparing(Flight::getDepartureDay).thenComparing(Flight::getDepartureTime);
        Collections.sort(upcomingFlights, flightsDayAndTimeComparator);
        for (Flight upcomingFlight : upcomingFlights) {
            logger.info(upcomingFlight);
        }
    }
}
