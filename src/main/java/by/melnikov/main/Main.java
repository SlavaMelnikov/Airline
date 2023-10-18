package by.melnikov.main;

import by.melnikov.creator.AirlineFactory;
import by.melnikov.entity.Airline;
import by.melnikov.service.AirlineService;
import by.melnikov.service.AirlineServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Main {
    public static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Airline airline = AirlineFactory.createAirline(".\\airline.txt");
        AirlineService airlineService = new AirlineServiceImpl();

        airlineService.showAllFlights(airline);
        System.out.println();
        airlineService.showAllFlightsTo(airline, "moscow");
        System.out.println();
        airlineService.showAllFlightsOn(airline, DayOfWeek.FRIDAY);
        System.out.println();
        airlineService.showAllFlightsOnAndAfter(airline, DayOfWeek.MONDAY, LocalTime.now());
        System.out.println();
        airlineService.showActualSchedule(airline, DayOfWeek.FRIDAY, LocalTime.parse("08:00"));
    }
}
